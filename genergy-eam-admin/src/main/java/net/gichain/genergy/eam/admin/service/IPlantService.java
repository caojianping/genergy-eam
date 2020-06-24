package net.gichain.genergy.eam.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.gichain.genergy.eam.admin.controller.vo.AssetVO;
import net.gichain.genergy.eam.common.exception.BusinessException;
import net.gichain.genergy.eam.database.entity.Plant;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cjp
 * @since 2020-06-18
 */
public interface IPlantService extends IService<Plant> {
    boolean savePlant(String plantId, AssetVO assetVO, boolean isEdit) throws BusinessException;
}
