package net.gichain.genergy.eam.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.admin.controller.vo.AssetVO;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.exception.BusinessException;
import net.gichain.genergy.eam.common.util.StringUtils;
import net.gichain.genergy.eam.database.entity.Plant;
import net.gichain.genergy.eam.database.enums.PlantStatusEnum;
import net.gichain.genergy.eam.database.enums.PlantTypeEnum;
import net.gichain.genergy.eam.database.mapper.PlantMapper;
import net.gichain.genergy.eam.admin.service.IPlantService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cjp
 * @since 2020-06-18
 */
@Slf4j
@Service
public class PlantServiceImpl extends ServiceImpl<PlantMapper, Plant> implements IPlantService {
    /**
     * 保存电站数据
     *
     * @param plantId 电站编号
     * @param assetVO 资产VO数据
     * @param isEdit  是否为编辑操作
     * @return
     * @throws BusinessException
     */
    @Override
    public boolean savePlant(String plantId, AssetVO assetVO, boolean isEdit) throws BusinessException {
        Plant plant = new Plant();
        if (!isEdit) {
            // 添加电站
            if (StringUtils.isNullOrEmpty(plantId)) {
                throw new BusinessException(CodeEnum.PLANT_ID_REQUIRED);
            }

            plant.setId(plantId);
            plant.setCreateTime(new Date());
            plant.setDeleted(false);
        } else {
            // 修改电站
            plant = this.getById(assetVO.getId());
            plant.setModifyTime(new Date());
        }

        plant.setPsId(assetVO.getPsId());
        plant.setCode(assetVO.getCode());
        plant.setName(assetVO.getPlantName());
        plant.setType(PlantTypeEnum.getEnumByValue(assetVO.getPlantType()));
        plant.setStatus(PlantStatusEnum.getEnumByValue(assetVO.getPlantStatus()));
        plant.setInstalledPower(assetVO.getInstalledPower());

        plant.setEstimatedAnnualEnergy(assetVO.getEstimatedAnnualEnergy());
        plant.setActualAnnualEnergy(assetVO.getActualAnnualEnergy());
        plant.setEstimatedAnnualEnergyEarnings(assetVO.getEstimatedAnnualEnergyEarnings());
        plant.setActualAnnualEnergyEarnings(assetVO.getActualAnnualEnergyEarnings());
        plant.setEstimatedAnnualEnergyMinEarningsRate(assetVO.getEstimatedAnnualEnergyMinEarningsRate());
        plant.setEstimatedAnnualEnergyMaxEarningsRate(assetVO.getEstimatedAnnualEnergyMaxEarningsRate());
        plant.setElectricityPrice(assetVO.getElectricityPrice());

        plant.setEnergyTerm(assetVO.getEnergyTerm());
        plant.setResidualEnergyTerm(assetVO.getResidualEnergyTerm());

        plant.setConstructionCompany(assetVO.getConstructionCompany());
        plant.setCompletedDate(assetVO.getCompletedDate());
        plant.setGridConnectedDate(assetVO.getGridConnectedDate());

        plant.setProvince(assetVO.getProvince());
        plant.setCity(assetVO.getCity());
        plant.setDistrict(assetVO.getDistrict());
        plant.setAddress(assetVO.getAddress());

        // todo: getCoordinateByCity()

        plant.setComponentTotal(assetVO.getComponentTotal());
        plant.setComponentSupplier(assetVO.getComponentSupplier());
        plant.setComponentModel(assetVO.getComponentModel());

        plant.setInverterSupplier(assetVO.getInverterSupplier());
        plant.setInverterModel(assetVO.getInverterModel());

        plant.setCollectorSupplier(assetVO.getCollectorSupplier());
        plant.setCollectorModel(assetVO.getCollectorModel());
        log.info("savePlant plant:" + plant);
        return this.saveOrUpdate(plant);
    }
}
