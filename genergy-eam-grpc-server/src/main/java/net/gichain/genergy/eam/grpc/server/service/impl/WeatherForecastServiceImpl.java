package net.gichain.genergy.eam.grpc.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.gichain.genergy.eam.grpc.server.service.IWeatherForecastService;
import net.gichain.genergy.eam.database.entity.WeatherForecast;
import net.gichain.genergy.eam.database.mapper.WeatherForecastMapper;
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
