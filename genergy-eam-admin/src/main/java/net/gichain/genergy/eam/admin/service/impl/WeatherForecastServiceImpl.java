package net.gichain.genergy.eam.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.gichain.genergy.eam.database.entity.WeatherForecast;
import net.gichain.genergy.eam.database.mapper.WeatherForecastMapper;
import net.gichain.genergy.eam.admin.service.IWeatherForecastService;
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
public class WeatherForecastServiceImpl extends ServiceImpl<WeatherForecastMapper, WeatherForecast> implements IWeatherForecastService {

}
