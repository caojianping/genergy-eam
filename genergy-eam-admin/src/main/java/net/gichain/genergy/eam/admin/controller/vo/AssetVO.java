package net.gichain.genergy.eam.admin.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.gichain.genergy.eam.database.enums.CompanyTypeEnum;
import net.gichain.genergy.eam.database.enums.CorpCertTypeEnum;
import net.gichain.genergy.eam.database.enums.PlantStatusEnum;
import net.gichain.genergy.eam.database.enums.PlantTypeEnum;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssetVO {

    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public class PlantAddressVO {
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
    }

    /**
     * 资产编号
     */
    private Long assetId;

    /**
     * 电站编号
     */
    private String plantId;

    /**
     * 电站PS编号
     */
    @NotNull(message = "电站PS编号不可以为空")
    private String psId;

    /**
     * 电站编码S/N
     */
    @NotNull(message = "电站编码S/N不可以为空")
    private String code;

    /**
     * 电站名称
     */
    @NotNull(message = "电站名称不可以为空")
    private String name;


    /**
     * 电站类型：0分布式光伏；1户用光伏；2户用储能；
     */
    private PlantTypeEnum type;

    /**
     * 电站状态：0禁用；1启用；
     */
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
     * 电站地址
     */
    private PlantAddressVO plantAddressVO;

    /**
     * 电站图片
     */
    private String[] imgs;


    /**
     * 企业名称，业主名称
     */
    private String companyName;

    /**
     * 企业类型
     */
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
    private CorpCertTypeEnum corpCertType;

    /**
     * 法人证件号码
     */
    private String corpCertNo;

    /**
     * 证件文件
     */
    private String[] certFiles;

    /**
     * 法律文件
     */
    private String[] legalFiles;

    /**
     * 电站建设价值
     */
    private String plantConstructionValue;

    /**
     * 电站预售价值
     */
    private String plantPresellValue;

    /**
     * 电站折旧率
     */
    private String plantDepreciationRate;

    /**
     * 电站特点
     */
    private String plantFeature;

    /**
     * 描述信息
     */
    private String description;
}