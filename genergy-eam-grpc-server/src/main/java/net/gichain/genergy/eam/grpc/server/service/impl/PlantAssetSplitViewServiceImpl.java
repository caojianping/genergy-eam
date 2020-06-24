package net.gichain.genergy.eam.grpc.server.service.impl;

import net.gichain.genergy.eam.database.entity.PlantAssetSplitView;
import net.gichain.genergy.eam.database.mapper.PlantAssetSplitViewMapper;
import net.gichain.genergy.eam.grpc.server.service.IPlantAssetSplitViewService;
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
public class PlantAssetSplitViewServiceImpl extends ServiceImpl<PlantAssetSplitViewMapper, PlantAssetSplitView> implements IPlantAssetSplitViewService {

}
