package net.gichain.genergy.eam.grpc.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.gichain.genergy.eam.grpc.server.service.IInsuranceRecordService;
import net.gichain.genergy.eam.database.entity.InsuranceRecord;
import net.gichain.genergy.eam.database.mapper.InsuranceRecordMapper;
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
public class InsuranceRecordServiceImpl extends ServiceImpl<InsuranceRecordMapper, InsuranceRecord> implements IInsuranceRecordService {

}
