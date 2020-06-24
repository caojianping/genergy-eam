package net.gichain.genergy.eam.database.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author cjp
 * @since 2020-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Energy implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 电量编号
     */
    private String id;

    /**
     * 电站编号
     */
    private String plantId;

    /**
     * 发电日期
     */
    private Date date;

    /**
     * 实际日发电量，单位kWh
     */
    private BigDecimal actualDailyEnergy;

    /**
     * 实际总发电量，单位kWh
     */
    private BigDecimal actualTotalEnergy;

    /**
     * 并网日发电量，单位kWh
     */
    private BigDecimal gridDailyEnergy;

    /**
     * 并网总发电量，单位kWh
     */
    private BigDecimal gridTotalEnergy;

    /**
     * 功率，单位kW
     */
    private BigDecimal power;

    /**
     * 功率负载比例
     */
    private BigDecimal loadRate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 是否删除
     */
    @TableField(value = "is_delete")
    private Boolean deleted;


}
