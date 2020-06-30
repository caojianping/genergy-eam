package net.gichain.genergy.eam.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.admin.controller.vo.AssetAuditVO;
import net.gichain.genergy.eam.admin.controller.vo.AssetVO;
import net.gichain.genergy.eam.admin.service.IPlantService;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.exception.BusinessException;
import net.gichain.genergy.eam.common.util.StringUtils;
import net.gichain.genergy.eam.common.util.UUIDUtils;
import net.gichain.genergy.eam.database.entity.Asset;
import net.gichain.genergy.eam.database.enums.AssetStatusEnum;
import net.gichain.genergy.eam.database.enums.CompanyTypeEnum;
import net.gichain.genergy.eam.database.enums.CorpCertTypeEnum;
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
@Slf4j
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

        // todo: 处理coinType

        if (!isEdit) {
            // 添加资产
            if (StringUtils.isNullOrEmpty(plantId)) {
                throw new BusinessException(CodeEnum.PLANT_ID_REQUIRED);
            }

            // 临时加个guid
            asset.setCoinType(UUIDUtils.randomWords(6, false));
            asset.setPlantId(plantId);
            asset.setPutawaySerial(UUIDUtils.randomWords(16, false));
            asset.setCreateTime(new Date());
            asset.setDeleted(false);
        } else {
            // 修改资产
            asset = this.getById(assetVO.getAssetId());
            asset.setModifyTime(new Date());
        }

        asset.setName(assetVO.getAssetName());

        asset.setCompanyName(assetVO.getCompanyName());
        asset.setCompanyType(CompanyTypeEnum.getEnumByValue(assetVO.getCompanyType()));
        asset.setCompanyAddress(assetVO.getCompanyAddress());

        asset.setCorpName(assetVO.getCorpName());
        asset.setCorpCertType(CorpCertTypeEnum.getEnumByValue(assetVO.getCorpCertType()));
        asset.setCorpCertNo(assetVO.getCorpCertNo());

        asset.setPlantConstructionValue(assetVO.getPlantConstructionValue());
        asset.setPlantPresellValue(assetVO.getPlantPresellValue());
        asset.setPlantDepreciationRate(assetVO.getPlantDepreciationRate());
        asset.setPlantFeature(assetVO.getPlantFeature());
        asset.setDescription(assetVO.getDescription());

        asset.setCertFiles(assetVO.getCertFiles());
        asset.setLegalFiles(assetVO.getLegalFiles());
        asset.setImgs(assetVO.getImgs());

        if (isSubmit) {
            asset.setStatus(AssetStatusEnum.SUBMITTED);
            asset.setSubmitBy(userId);
            asset.setSubmitTime(new Date());
        } else {
            asset.setStatus(AssetStatusEnum.CREATED);
        }
        log.info("saveAsset asset:" + asset);
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
        boolean isEdit = assetVO.getAssetId() != null;
        String plantId = isEdit ? assetVO.getId() : UUIDUtils.randomWords(10, true);
        log.info("plantId:" + plantId);
        this.saveAsset(userId, plantId, assetVO, isEdit, isSubmit);
        plantService.savePlant(plantId, assetVO, isEdit);
        return true;
    }

    /**
     * 设置资产状态
     *
     * @param useId        用户编号
     * @param assetAuditVO 资产审核VO数据
     * @return
     * @throws BusinessException
     */
    @Override
    public boolean setStatus(int useId, AssetAuditVO assetAuditVO) throws BusinessException {
        AssetStatusEnum assetStatus = AssetStatusEnum.getEnumByValue(assetAuditVO.getStatus());
        if (assetStatus != AssetStatusEnum.AUDITED) {
            throw new BusinessException(CodeEnum.ASSET_AUDIT_SCOPE);
        }

        Long assetId = assetAuditVO.getAssetId();
        Asset asset = this.getById(assetId);
        if (asset.getStatus() != AssetStatusEnum.SUBMITTED) {
            throw new BusinessException(CodeEnum.ASSET_AUDIT_PRECONDITION);
        }

        asset.setStatus(assetStatus);
        asset.setAuditBy(useId);
        asset.setAuditRemark(assetAuditVO.getAuditRemark());
        asset.setPutawayTime(new Date());
        return this.updateById(asset);
    }
}
