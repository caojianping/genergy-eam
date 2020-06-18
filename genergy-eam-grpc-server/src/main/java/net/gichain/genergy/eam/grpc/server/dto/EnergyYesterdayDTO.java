package net.gichain.genergy.eam.grpc.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.gichain.genergy.eam.database.entity.PlantAssetEnergyView;

import java.math.BigDecimal;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnergyYesterdayDTO {
    private Long assetId;
    private LocalDate date;
    private BigDecimal energy;

    public static EnergyYesterdayDTO convertFromView(PlantAssetEnergyView view) {
        EnergyYesterdayDTO result = new EnergyYesterdayDTO();
        result.assetId = view.getAssetId();
        result.date = view.getDate();
        result.energy = view.getGridDailyEnergy();
        return result;
    }
}
