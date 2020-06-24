package net.gichain.genergy.eam.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import net.gichain.genergy.eam.admin.controller.dto.AssetDTO;
import net.gichain.genergy.eam.database.entity.PlantAssetView;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author cjp
 * @since 2020-06-19
 */
public interface IPlantAssetViewService extends IService<PlantAssetView> {
    boolean isExist(long assetId);

    IPage<AssetDTO> pageAssets(
            int current,
            int size,
            String putawaySerial,
            String plantName,
            String submitter,
            String auditor,
            Integer status
    );

    PlantAssetView getDetail(long assetId);
}
