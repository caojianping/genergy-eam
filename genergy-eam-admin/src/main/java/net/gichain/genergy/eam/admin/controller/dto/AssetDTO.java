package net.gichain.genergy.eam.admin.controller.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.gichain.genergy.eam.database.entity.PlantAssetView;
import net.gichain.genergy.eam.database.enums.AssetStatusEnum;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AssetDTO {
    /**
     * 资产编号
     */
    private Long assetId;

    /**
     * 上架序号
     */
    private String putawaySerial;

    /**
     * 电站名称
     */
    private String plantName;

    /**
     * 提交人编号
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
     * 审核人编号
     */
    private Integer auditorId;

    /**
     * 审核人名称
     */
    private String auditorName;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 资产状态
     */
    private AssetStatusEnum assetStatus;

    public static IPage<AssetDTO> convertFromViewPage(IPage<PlantAssetView> viewPage) {
        return viewPage.convert(view -> {
            AssetDTO dto = new AssetDTO();
            BeanUtils.copyProperties(view, dto);
            dto.setAuditTime(view.getPutawayTime());
            return dto;
        });
    }
}
