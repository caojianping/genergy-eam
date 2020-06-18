package net.gichain.genergy.eam.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.gichain.genergy.eam.database.entity.Plant;
import net.gichain.genergy.eam.database.mapper.PlantMapper;
import net.gichain.genergy.eam.admin.service.IPlantService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cjp
 * @since 2020-06-18
 */
@Service
public class PlantServiceImpl extends ServiceImpl<PlantMapper, Plant> implements IPlantService {

}
