package net.gichain.genergy.eam.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.gichain.genergy.eam.admin.service.IEnergyService;
import net.gichain.genergy.eam.database.entity.Energy;
import net.gichain.genergy.eam.database.mapper.EnergyMapper;
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
public class EnergyServiceImpl extends ServiceImpl<EnergyMapper, Energy> implements IEnergyService {

}
