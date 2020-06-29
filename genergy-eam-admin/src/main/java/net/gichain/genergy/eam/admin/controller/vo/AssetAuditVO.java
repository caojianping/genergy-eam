package net.gichain.genergy.eam.admin.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssetAuditVO {
    @NotNull(message = "资产编号不可以为空")
    private Long assetId;

    @NotNull(message = "资产状态不可以为空")
    private Integer status;

    private String auditRemark;
}
