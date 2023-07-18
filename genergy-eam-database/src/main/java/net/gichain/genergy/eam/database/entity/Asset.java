package net.gichain.genergy.eam.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.gichain.genergy.eam.database.enums.AssetStatusEnum;
import net.gichain.genergy.eam.database.enums.CompanyTypeEnum;
import net.gichain.genergy.eam.database.enums.CorpCertTypeEnum;
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
public class Asset implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资产编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 资产币种
     */
    private String coinType;

    /**
     * 电站编号
     */
    private String plantId;

    /**
     * 上架序号
     */
    private String putawaySerial;

    /**
     * 资产名称
     */
    private String name;

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
     * 现场照片
     */
    private String imgs;

    /**
     * 资产状态：0已创建/已保存/待提交；10已提交/待审核；20已审核；
     */
    @TableField(value = "status", jdbcType = JdbcType.INTEGER)
    private AssetStatusEnum status;

    /**
     * 提交人
     */
    private Integer submitBy;

    /**
     * 提交时间
     */
    private Date submitTime;

    /**
     * 审核人
     */
    private Integer auditBy;

    /**
     * 审核备注
     */
    private String auditRemark;

    /**
     * 上架时间
     */
    private Date putawayTime;

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
