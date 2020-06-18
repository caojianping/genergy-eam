package net.gichain.genergy.eam.database.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author cjp
 * @since 2020-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PlantAssetView implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 电站编号
     */
    private String plantId;

    /**
     * 资产编号
     */
    private Long assetId;

    /**
     * 上网电价（精确到分），单位元
     */
    private BigDecimal electricityPrice;


}
