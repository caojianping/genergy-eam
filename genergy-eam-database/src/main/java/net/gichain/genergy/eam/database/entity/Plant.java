package net.gichain.genergy.eam.database.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.gichain.genergy.eam.database.enums.PlantStatusEnum;
import net.gichain.genergy.eam.database.enums.PlantTypeEnum;
import org.apache.ibatis.type.JdbcType;

/**
 * <p>
 *
 * </p>
 *
 * @author cjp
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Plant implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 电站编号
     */
    private String id;

    /**
     * 电站PS编号
     */
    private String psId;

    /**
     * 电站编码S/N
     */
    private String code;

    /**
     * 电站名称
     */
    private String name;

    /**
     * 电站类型：0分布式光伏；1户用光伏；2户用储能；
     */
    @TableField(value = "type", jdbcType = JdbcType.INTEGER)
    private PlantTypeEnum type;

    /**
     * 电站状态：0禁用；1启用；
     */
    @TableField(value = "status", jdbcType = JdbcType.INTEGER)
    private PlantStatusEnum status;

    /**
     * 装机功率，单位kWp
     */
    private BigDecimal installedPower;

    /**
     * 预计年发电量，单位kWh
     */
    private BigDecimal estimatedAnnualEnergy;

    /**
     * 实际年发电量，单位kWh
     */
    private BigDecimal actualAnnualEnergy;

    /**
     * 预计年发电收益，单位元
     */
    private BigDecimal estimatedAnnualEnergyEarnings;

    /**
     * 实际年发电收益，单位元
     */
    private BigDecimal actualAnnualEnergyEarnings;

    /**
     * 预计年发电最小收益率
     */
    private BigDecimal estimatedAnnualEnergyMinEarningsRate;

    /**
     * 预计年发电最大收益率
     */
    private BigDecimal estimatedAnnualEnergyMaxEarningsRate;

    /**
     * 累计发电量，单位kWh
     */
    private BigDecimal totalEnergy;

    /**
     * 上网电价，单位元
     */
    private BigDecimal electricityPrice;

    /**
     * 发电年限，单位天
     */
    private Integer energyTerm;

    /**
     * 剩余发电年限，单位天
     */
    private Integer residualEnergyTerm;

    /**
     * 建设公司
     */
    private String constructionCompany;

    /**
     * 建成日期
     */
    private Date completedDate;

    /**
     * 并网日期
     */
    private Date gridConnectedDate;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 县
     */
    private String district;

    /**
     * 地址
     */
    private String address;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 组件总数
     */
    private Integer componentTotal;

    /**
     * 组件厂家
     */
    private String componentSupplier;

    /**
     * 组件型号
     */
    private String componentModel;

    /**
     * 逆变器厂家
     */
    private String inverterSupplier;

    /**
     * 逆变器型号
     */
    private String inverterModel;

    /**
     * 数据采集器厂家
     */
    private String collectorSupplier;

    /**
     * 数据采集器型号
     */
    private String collectorModel;

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
