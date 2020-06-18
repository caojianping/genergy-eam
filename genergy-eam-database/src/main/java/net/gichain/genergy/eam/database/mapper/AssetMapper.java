package net.gichain.genergy.eam.database.mapper;

import net.gichain.genergy.eam.database.entity.Asset;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author cjp
 * @since 2020-06-17
 */
public interface AssetMapper extends BaseMapper<Asset> {
    @Select("select plant_id from asset where id = #{assetId})")
    HashMap<String, String> getPlantIdByAssetId(int assetId);
}
