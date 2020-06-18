package net.gichain.genergy.eam.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Inverter implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 逆变器编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 逆变器名称
     */
    private String name;

    /**
     * 逆变器类型
     */
    private String type;

    /**
     * 逆变器型号
     */
    private String model;

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
