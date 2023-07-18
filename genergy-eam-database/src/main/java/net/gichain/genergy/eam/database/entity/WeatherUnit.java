package net.gichain.genergy.eam.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

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
public class WeatherUnit implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 天气单位编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 单位名称
     */
    private String name;

    /**
     * 单位值
     */
    private String value;


}
