package net.gichain.genergy.eam.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.gichain.genergy.eam.database.entity.Asset;
import net.gichain.genergy.eam.database.mapper.AssetMapper;
import net.gichain.genergy.eam.admin.service.IAssetService;
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
public class AssetServiceImpl extends ServiceImpl<AssetMapper, Asset> implements IAssetService {

}
