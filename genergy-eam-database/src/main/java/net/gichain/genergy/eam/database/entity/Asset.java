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
public class Asset implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资产编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 电站编号
     */
    private Integer powerStationId;

    /**
     * 资产名称
     */
    private String name;

    /**
     * 文件、合同、图片信息
     */
    private String files;

    /**
     * 资产状态
     */
    private Integer status;

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
