package net.gichain.genergy.eam.database.entity;

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
 * @since 2020-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WeatherForecast implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 天气预报编号
     */
    private String id;

    /**
     * 城市编号
     */
    private Integer cityId;

    /**
     * 天气日期
     */
    private Date date;

    /**
     * 温度
     */
    private Integer temperature;

    /**
     * 天气单位
     */
    private String weatherUnits;

    /**
     * 天气描述
     */
    private String weatherDesc;

    /**
     * 风向、风力
     */
    private String wind;

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
