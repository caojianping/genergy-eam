package net.gichain.genergy.eam.grpc.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.gichain.genergy.eam.grpc.server.service.IMaintainRecordService;
import net.gichain.genergy.eam.database.entity.MaintainRecord;
import net.gichain.genergy.eam.database.mapper.MaintainRecordMapper;
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
public class MaintainRecordServiceImpl extends ServiceImpl<MaintainRecordMapper, MaintainRecord> implements IMaintainRecordService {

}
