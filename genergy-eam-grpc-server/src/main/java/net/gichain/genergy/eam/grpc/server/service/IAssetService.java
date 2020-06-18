package net.gichain.genergy.eam.grpc.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.gichain.genergy.eam.database.entity.Asset;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cjp
 * @since 2020-06-17
 */
public interface IAssetService extends IService<Asset> {
    String getPlantIdByAssetId(int assetId);
}
