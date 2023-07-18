package net.gichain.genergy.eam.admin.service;

import net.gichain.genergy.eam.admin.controller.vo.AssetAuditVO;
import net.gichain.genergy.eam.admin.controller.vo.AssetVO;
import net.gichain.genergy.eam.common.exception.BusinessException;
import net.gichain.genergy.eam.database.entity.Asset;
import com.baomidou.mybatisplus.extension.service.IService;
import net.gichain.genergy.eam.database.enums.AssetStatusEnum;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cjp
 * @since 2020-06-17
 */
public interface IAssetService extends IService<Asset> {
    boolean saveAsset(int userId, String plantId, AssetVO assetVO, boolean isEdit, boolean isSubmit) throws BusinessException;

    boolean saveCombinedData(int userId, AssetVO assetVO, boolean isSubmit) throws BusinessException;

    boolean setStatus(int userId, AssetAuditVO assetAuditVO) throws BusinessException;
}
