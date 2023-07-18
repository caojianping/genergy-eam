package net.gichain.genergy.eam.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.gichain.genergy.eam.database.entity.WeatherCity;
import net.gichain.genergy.eam.database.mapper.WeatherCityMapper;
import net.gichain.genergy.eam.admin.service.IWeatherCityService;
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
public class WeatherCityServiceImpl extends ServiceImpl<WeatherCityMapper, WeatherCity> implements IWeatherCityService {

}
