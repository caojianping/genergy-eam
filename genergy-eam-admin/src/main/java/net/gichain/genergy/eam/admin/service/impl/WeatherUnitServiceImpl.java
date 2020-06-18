package net.gichain.genergy.eam.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.gichain.genergy.eam.database.entity.WeatherUnit;
import net.gichain.genergy.eam.database.mapper.WeatherUnitMapper;
import net.gichain.genergy.eam.admin.service.IWeatherUnitService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cjp
 * @since 2020-06-17
 */
@Service
public class WeatherUnitServiceImpl extends ServiceImpl<WeatherUnitMapper, WeatherUnit> implements IWeatherUnitService {

}
