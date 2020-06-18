package net.gichain.genergy.eam.database.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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
public class PlantAssetEnergyView implements Serializable {

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
     * 电量编号
     */
    private String energyId;

    /**
     * 发电日期
     */
    private LocalDate date;

    /**
     * 实际日发电量，单位kWh
     */
    private BigDecimal actualDailyEnergy;

    /**
     * 并网日发电量，单位kWh
     */
    private BigDecimal gridDailyEnergy;


}
