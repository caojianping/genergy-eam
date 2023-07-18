package net.gichain.genergy.eam.database.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author cjp
 * @since 2020-06-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PlantAssetSplitView implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 电站编号
     */
    private String id;

    /**
     * 装机功率，单位kWp
     */
    private BigDecimal installedPower;

    /**
     * 预计年发电量，单位kWh
     */
    private BigDecimal estimatedAnnualEnergy;

    /**
     * 上网电价（精确到分），单位元
     */
    private BigDecimal electricityPrice;

    /**
     * 剩余发电年限，单位天
     */
    private Integer residualEnergyTerm;

    /**
     * 建设公司
     */
    private String constructionCompany;

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
     * 资产编号
     */
    private Long assetId;

    /**
     * 企业名称，业主名称
     */
    private String companyName;

    /**
     * 图片信息
     */
    private String imgs;

    /**
     * 资产拆分编号
     */
    private Long assetSplitId;

    /**
     * 组件总份额
     */
    private Integer totalShares;
}
