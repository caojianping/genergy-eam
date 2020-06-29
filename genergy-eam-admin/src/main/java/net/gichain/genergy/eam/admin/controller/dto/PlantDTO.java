package net.gichain.genergy.eam.admin.controller.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.gichain.genergy.eam.database.entity.PlantAssetView;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlantDTO {
    /**
     * 电站编号
     */
    private String id;

    /**
     * 上架序号
     */
    private String putawaySerial;

    /**
     * 上架时间
     */
    private Date putawayTime;

    /**
     * 电站名称
     */
    private String plantName;

    /**
     * 装机功率，单位kWp
     */
    private BigDecimal installedPower;

    /**
     * 上网电价（精确到分），单位元
     */
    private BigDecimal electricityPrice;

    /**
     * 累计发电量
     */
    private BigDecimal totalEnergy;

    /**
     * 累计已结算电费（元）
     */
    private BigDecimal totalEnergyCost;

    public static IPage<PlantDTO> convertFromViewPage(IPage<PlantAssetView> viewPage) {
        return viewPage.convert(view -> {
            PlantDTO dto = new PlantDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        });
    }
}
