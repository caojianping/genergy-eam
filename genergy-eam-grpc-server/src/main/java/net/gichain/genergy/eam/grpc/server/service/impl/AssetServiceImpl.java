package net.gichain.genergy.eam.grpc.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.gichain.genergy.eam.grpc.server.service.IAssetService;
import net.gichain.genergy.eam.database.entity.Asset;
import net.gichain.genergy.eam.database.mapper.AssetMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cjp
 * @since 2020-06-17
 */
@Service
public class AssetServiceImpl extends ServiceImpl<AssetMapper, Asset> implements IAssetService {
    @Override
    public String getPlantIdByAssetId(int assetId) {
        HashMap<String, String> map = this.baseMapper.getPlantIdByAssetId(assetId);
        return map.get("plant_id");
    }
}
