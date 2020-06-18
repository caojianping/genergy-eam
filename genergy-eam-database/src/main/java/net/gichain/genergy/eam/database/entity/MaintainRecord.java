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
 * @since 2020-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MaintainRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 运维记录编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 处理人编号
     */
    private Integer userId;

    /**
     * 维修对象类型
     */
    private Integer themeType;

    /**
     * 维修对象编号
     */
    private Integer themeId;

    /**
     * 操作类型
     */
    private Integer operationType;

    /**
     * 文件信息
     */
    private String files;

    /**
     * 记录状态
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
