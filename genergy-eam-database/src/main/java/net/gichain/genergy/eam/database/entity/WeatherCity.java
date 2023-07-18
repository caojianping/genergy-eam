package net.gichain.genergy.eam.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

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
public class WeatherCity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 城市编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String district;

    /**
     * 状态
     */
    private Integer status;

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
