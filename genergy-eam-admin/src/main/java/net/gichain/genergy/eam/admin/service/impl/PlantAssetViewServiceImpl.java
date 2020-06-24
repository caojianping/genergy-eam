package net.gichain.genergy.eam.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.gichain.genergy.eam.admin.controller.dto.AssetDTO;
import net.gichain.genergy.eam.common.util.StringUtils;
import net.gichain.genergy.eam.database.entity.PlantAssetView;
import net.gichain.genergy.eam.database.mapper.PlantAssetViewMapper;
import net.gichain.genergy.eam.admin.service.IPlantAssetViewService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author cjp
 * @since 2020-06-19
 */
@Service
public class PlantAssetViewServiceImpl extends ServiceImpl<PlantAssetViewMapper, PlantAssetView> implements IPlantAssetViewService {
    @Override
    public boolean isExist(long assetId) {
        PlantAssetView view = this.getOne(new QueryWrapper<PlantAssetView>().eq("asset_id", assetId));
        return view != null;
    }

    @Override
    public IPage<AssetDTO> pageAssets(
            int current,
            int size,
            String putawaySerial,
            String plantName,
            String submitter,
            String auditor,
            Integer status
    ) {
        if (current <= 0) {
            current = 1;
        }
        if (size > 1000) {
            size = 1000;
        }

        Page<PlantAssetView> pageParameters = new Page<PlantAssetView>(current, size);
        QueryWrapper<PlantAssetView> queryParameters = new QueryWrapper<PlantAssetView>();
        if (StringUtils.isNullOrEmpty(putawaySerial)) {
            queryParameters = queryParameters.eq("putaway_serial", putawaySerial);
        }
        if (StringUtils.isNullOrEmpty(plantName)) {
            queryParameters = queryParameters.like("name", plantName);
        }
        if (StringUtils.isNullOrEmpty(submitter)) {
            queryParameters = queryParameters.like("submitter_name", submitter);
        }
        if (StringUtils.isNullOrEmpty(auditor)) {
            queryParameters = queryParameters.like("auditor_name", auditor);
        }
        if (status != null) {
            queryParameters = queryParameters.eq("asset_status", status);
        }

        IPage<PlantAssetView> pageResult = this.page(pageParameters, queryParameters);
        return AssetDTO.convertFromViewPage(pageResult);
    }

    @Override
    public PlantAssetView getDetail(long assetId) {
        return this.getOne(new QueryWrapper<PlantAssetView>().eq("asset_id", assetId));
    }
}
