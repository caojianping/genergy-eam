package net.gichain.genergy.eam.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.admin.controller.dto.AssetDTO;
import net.gichain.genergy.eam.admin.controller.dto.PlantDTO;
import net.gichain.genergy.eam.admin.enums.UploadTypeEnum;
import net.gichain.genergy.eam.common.util.StringUtils;
import net.gichain.genergy.eam.database.entity.PlantAssetView;
import net.gichain.genergy.eam.database.enums.AssetStatusEnum;
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
@Slf4j
@Service
public class PlantAssetViewServiceImpl extends ServiceImpl<PlantAssetViewMapper, PlantAssetView> implements IPlantAssetViewService {
    @Override
    public boolean isExist(long assetId) {
        PlantAssetView view = this.getOne(new QueryWrapper<PlantAssetView>().eq("asset_id", assetId));
        return view != null;
    }

    @Override
    public boolean isExistByPlantName(String plantName) {
        PlantAssetView view = this.getOne(new QueryWrapper<PlantAssetView>().eq("plant_name", plantName));
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
        if (!StringUtils.isNullOrEmpty(putawaySerial)) {
            queryParameters = queryParameters.eq("putaway_serial", putawaySerial);
        }
        if (!StringUtils.isNullOrEmpty(plantName)) {
            queryParameters = queryParameters.like("plant_name", plantName);
        }
        if (!StringUtils.isNullOrEmpty(submitter)) {
            queryParameters = queryParameters.like("submitter_name", submitter);
        }
        if (!StringUtils.isNullOrEmpty(auditor)) {
            queryParameters = queryParameters.like("auditor_name", auditor);
        }
        if (status != null) {
            queryParameters = queryParameters.eq("asset_status", status);
        }
        log.info("pageAssets queryParameters:" + queryParameters);

        IPage<PlantAssetView> pageResult = this.page(pageParameters, queryParameters);
        return AssetDTO.convertFromViewPage(pageResult);
    }

    @Override
    public IPage<PlantDTO> pagePlants(
            int current,
            int size,
            String putawaySerial,
            String plantName,
            String putawayStartTime,
            String putawayEndTime
    ) {
        if (current <= 0) {
            current = 1;
        }
        if (size > 1000) {
            size = 1000;
        }

        Page<PlantAssetView> pageParameters = new Page<PlantAssetView>(current, size);
        QueryWrapper<PlantAssetView> queryParameters = new QueryWrapper<PlantAssetView>();
        queryParameters.eq("asset_status", AssetStatusEnum.AUDITED.getValue());
        if (!StringUtils.isNullOrEmpty(putawaySerial)) {
            queryParameters = queryParameters.eq("putaway_serial", putawaySerial);
        }
        if (!StringUtils.isNullOrEmpty(plantName)) {
            queryParameters = queryParameters.like("plant_name", plantName);
        }
        if (!StringUtils.isNullOrEmpty(putawayStartTime) && StringUtils.isNullOrEmpty(putawayEndTime)) {
            queryParameters = queryParameters.ge("putaway_time", putawayStartTime);
        } else if (StringUtils.isNullOrEmpty(putawayStartTime) && !StringUtils.isNullOrEmpty(putawayEndTime)) {
            queryParameters = queryParameters.le("putaway_time", putawayEndTime);
        } else if (!StringUtils.isNullOrEmpty(putawayStartTime) && !StringUtils.isNullOrEmpty(putawayEndTime)) {
            queryParameters = queryParameters.between("putaway_time", putawayStartTime, putawayEndTime);
        }

        IPage<PlantAssetView> pageResult = this.page(pageParameters, queryParameters);
        return PlantDTO.convertFromViewPage(pageResult);
    }

    @Override
    public PlantAssetView getDetail(long assetId) {
        return this.getOne(new QueryWrapper<PlantAssetView>().eq("asset_id", assetId));
    }

    @Override
    public String[] getStaticsByAssetId(long assetId, UploadTypeEnum uploadType) {
        PlantAssetView record = this.getDetail(assetId);
        if (record == null) {
            return new String[]{};
        }

        if (uploadType == UploadTypeEnum.CERT_UPLOAD) {
            return StringUtils.separate(record.getCertFiles(), ",");
        } else if (uploadType == UploadTypeEnum.LEGAL_UPLOAD) {
            return StringUtils.separate(record.getLegalFiles(), ",");
        } else if (uploadType == UploadTypeEnum.IMG_UPLOAD) {
            return StringUtils.separate(record.getImgs(), ",");
        } else {
            return new String[]{};
        }
    }
}
