package net.gichain.genergy.eam.grpc.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.gichain.genergy.eam.database.entity.PlantAssetEnergyView;
import net.gichain.genergy.eam.database.mapper.PlantAssetEnergyViewMapper;
import net.gichain.genergy.eam.grpc.server.service.IPlantAssetEnergyViewService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author cjp
 * @since 2020-06-18
 */
@Service
public class PlantAssetEnergyViewServiceImpl extends ServiceImpl<PlantAssetEnergyViewMapper, PlantAssetEnergyView> implements IPlantAssetEnergyViewService {

}
