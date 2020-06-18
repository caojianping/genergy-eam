package net.gichain.genergy.eam.database.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author cjp
 * @since 2020-06-17
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
     * 电站类型
     */
    private Integer type;

    /**
     * 电站状态
     */
    private Integer status;

    /**
     * 装机功率，单位kWp
     */
    private Integer installedPower;

    /**
     * 预计年发电量，单位kWh
     */
    private Integer estimatedAnnualEnergy;

    /**
     * 预计年发电收益，单位元
     */
    private Integer estimatedAnnualEnergyEarnings;

    /**
     * 预计年发电最小收益率
     */
    private BigDecimal estimatedAnnualEnergyMinEarningsRate;

    /**
     * 预计年发电最大收益率
     */
    private BigDecimal estimatedAnnualEnergyMaxEarningsRate;

    /**
     * 上网电价（精确到分），单位元
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
     * 并网日期
     */
    private LocalDate gridConnectedDate;

    /**
     * 建设公司
     */
    private String constructionCompany;

    /**
     * 建成日期
     */
    private LocalDate completedDate;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 地址
     */
    private String address;

    /**
     * 组件总数
     */
    private Integer componentTotal;

    /**
     * 组件厂家
     */
    private String componentSupplier;

    /**
     * 组件品牌
     */
    private String componentBrand;

    /**
     * 组件型号
     */
    private String componentModel;

    /**
     * 逆变器厂家
     */
    private String inverterSupplier;

    /**
     * 逆变器品牌
     */
    private String inverterBrand;

    /**
     * 逆变器型号
     */
    private String inverterModel;

    /**
     * 数据采集器厂家
     */
    private String collectorSupplier;

    /**
     * 数据采集器品牌
     */
    private String collectorBrand;

    /**
     * 数据采集器型号
     */
    private String collectorModel;

    /**
     * 图片信息
     */
    private String imgs;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 是否删除
     */
    private Boolean isDelete;


}
