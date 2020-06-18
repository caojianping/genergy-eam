package net.gichain.genergy.eam.grpc.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.gichain.genergy.eam.database.entity.PlantAssetEnergyView;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnergyTrendDTO {
    private LocalDate date;
    private BigDecimal energy;

    public static List<EnergyTrendDTO> convertFromViews(List<PlantAssetEnergyView> views) {
        return (List<EnergyTrendDTO>) views.stream().map(view -> {
            EnergyTrendDTO result = new EnergyTrendDTO();
            result.date = view.getDate();
            result.energy = view.getGridDailyEnergy();
            return result;
        }).collect(Collectors.toList());
    }
}
