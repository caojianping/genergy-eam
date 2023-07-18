package net.gichain.genergy.eam.database.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.gichain.genergy.eam.database.enums.*;
import org.apache.ibatis.type.JdbcType;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author cjp
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PlantAssetView implements Serializable {

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
    private String plantName;

    /**
     * 电站类型：0分布式光伏；1户用光伏；2户用储能；
     */
    @TableField(value = "plant_type", jdbcType = JdbcType.INTEGER)
    private PlantTypeEnum plantType;

    /**
     * 电站状态：0禁用；1启用；
     */
    @TableField(value = "plant_status", jdbcType = JdbcType.INTEGER)
    private PlantStatusEnum plantStatus;

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
     * 资产编号
     */
    private Long assetId;

    /**
     * 资产币种
     */
    private String coinType;

    /**
     * 上架序号
     */
    private String putawaySerial;

    /**
     * 企业名称，业主名称
     */
    private String companyName;

    /**
     * 企业类型
     */
    @TableField(value = "company_type", jdbcType = JdbcType.INTEGER)
    private CompanyTypeEnum companyType;

    /**
     * 企业地址
     */
    private String companyAddress;

    /**
     * 法人代表
     */
    private String corpName;

    /**
     * 法人证件类型
     */
    @TableField(value = "corp_cert_type", jdbcType = JdbcType.INTEGER)
    private CorpCertTypeEnum corpCertType;

    /**
     * 法人证件号码
     */
    private String corpCertNo;

    /**
     * 电站建设价值
     */
    private BigDecimal plantConstructionValue;

    /**
     * 电站预售价值
     */
    private BigDecimal plantPresellValue;

    /**
     * 电站折旧率
     */
    private BigDecimal plantDepreciationRate;

    /**
     * 电站特点
     */
    private String plantFeature;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 证件文件
     */
    private String certFiles;

    /**
     * 法律文件
     */
    private String legalFiles;

    /**
     * 图片信息
     */
    private String imgs;

    /**
     * 资产状态：0已创建/已保存/待提交；10已提交/待审核；20已审核；
     */
    @TableField(value = "asset_status", jdbcType = JdbcType.INTEGER)
    private AssetStatusEnum assetStatus;

    /**
     * 提交人
     */
    private Integer submitterId;

    /**
     * 提交人名称
     */
    private String submitterName;

    /**
     * 提交时间
     */
    private Date submitTime;

    /**
     * 审核人
     */
    private Integer auditorId;

    /**
     * 审核人名称
     */
    private String auditorName;

    /**
     * 审核备注
     */
    private String auditRemark;

    /**
     * 上架时间
     */
    private Date putawayTime;

    /**
     * 是否删除
     */
    @TableField(value = "is_delete")
    private Boolean deleted;
}
