package net.gichain.genergy.eam.grpc.server.service.impl;

import net.gichain.genergy.eam.database.entity.PlantAssetView;
import net.gichain.genergy.eam.database.mapper.PlantAssetViewMapper;
import net.gichain.genergy.eam.grpc.server.service.IPlantAssetViewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
