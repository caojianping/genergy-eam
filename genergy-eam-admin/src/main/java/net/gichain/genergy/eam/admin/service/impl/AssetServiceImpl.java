package net.gichain.genergy.eam.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.gichain.genergy.eam.admin.controller.vo.AssetVO;
import net.gichain.genergy.eam.admin.service.IPlantService;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.exception.BusinessException;
import net.gichain.genergy.eam.common.util.StringUtils;
import net.gichain.genergy.eam.common.util.UUIDUtils;
import net.gichain.genergy.eam.database.entity.Asset;
import net.gichain.genergy.eam.database.enums.AssetStatusEnum;
import net.gichain.genergy.eam.database.mapper.AssetMapper;
import net.gichain.genergy.eam.admin.service.IAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cjp
 * @since 2020-06-17
 */
@Service
public class AssetServiceImpl extends ServiceImpl<AssetMapper, Asset> implements IAssetService {

    @Autowired
    private IPlantService plantService;

    /**
     * 保存资产
     *
     * @param userId   用户编号
     * @param plantId  电站编号
     * @param assetVO  资产VO数据
     * @param isEdit   是否为编辑操作
     * @param isSubmit 是否为提交操作
     * @return
     * @throws BusinessException
     */
    @Override
    public boolean saveAsset(int userId, String plantId, AssetVO assetVO, boolean isEdit, boolean isSubmit) throws BusinessException {
        Asset asset = new Asset();

        // 添加资产
        if (!isEdit) {
            if (StringUtils.isNullOrEmpty(plantId)) {
                throw new BusinessException(CodeEnum.PLANT_ID_REQUIRED);
            }

            asset.setPlantId(plantId);
            asset.setPutawaySerial(UUIDUtils.randomWords(16, false));
            asset.setCreateTime(new Date());
            asset.setDeleted(false);
        } else {
            asset.setModifyTime(new Date());
        }

        asset.setName(assetVO.getName());
        asset.setCompanyName(assetVO.getCompanyName());
        asset.setCompanyType(assetVO.getCompanyType());
        asset.setCompanyAddress(assetVO.getCompanyAddress());

        asset.setCorpName(assetVO.getCorpName());
        asset.setCorpCertType(assetVO.getCorpCertType());
        asset.setCorpCertNo(assetVO.getCorpCertNo());

        asset.setPlantConstructionValue(assetVO.getPlantConstructionValue());
        asset.setPlantPresellValue(assetVO.getPlantPresellValue());
        asset.setPlantDepreciationRate(assetVO.getPlantDepreciationRate());
        asset.setPlantFeature(assetVO.getPlantFeature());

        asset.setCertFiles(String.join(",", assetVO.getCertFiles()));
        asset.setLegalFiles(String.join(",", assetVO.getLegalFiles()));

        asset.setDescription(asset.getDescription());

        if (isSubmit) {
            asset.setStatus(AssetStatusEnum.SUBMITTED);
            asset.setSubmitBy(userId);
            asset.setSubmitTime(new Date());
        } else {
            asset.setStatus(AssetStatusEnum.CREATED);
        }
        return this.saveOrUpdate(asset);
    }

    /**
     * 保存组合数据
     *
     * @param userId   用户编号
     * @param assetVO  资产VO数据
     * @param isSubmit 是否为提交操作
     * @return
     * @throws BusinessException
     */
    @Transactional
    @Override
    public boolean saveCombinedData(int userId, AssetVO assetVO, boolean isSubmit) throws BusinessException {
        String plantId = null;
        boolean isEdit = assetVO.getAssetId() != null;
        if (!isEdit) {
            plantId = UUIDUtils.randomWords(10, true);
        }
        this.saveAsset(userId, plantId, assetVO, isEdit, isSubmit);
        plantService.savePlant(plantId, assetVO, isEdit);
        return true;
    }

    /**
     * 设置资产状态
     *
     * @param useId   用户编号
     * @param assetId 资产编号
     * @param status  资产状态
     * @return
     * @throws BusinessException
     */
    @Override
    public boolean setStatus(int useId, long assetId, AssetStatusEnum status) throws BusinessException {
        if (status != AssetStatusEnum.AUDITED) {
            throw new BusinessException(CodeEnum.ASSET_AUDIT_SCOPE);
        }

        Asset originAsset = this.getById(assetId);
        if (originAsset.getStatus() != AssetStatusEnum.SUBMITTED) {
            throw new BusinessException(CodeEnum.ASSET_AUDIT_PRECONDITION);
        }

        Asset updateAsset = new Asset();
        updateAsset.setId(assetId);
        updateAsset.setStatus(status);
        updateAsset.setSubmitBy(useId);
        updateAsset.setPutawayTime(new Date());
        return this.updateById(updateAsset);
    }
}
