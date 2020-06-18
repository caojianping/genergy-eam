package net.gichain.genergy.eam.grpc.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.gichain.genergy.eam.database.entity.PlantAssetView;

import java.math.BigDecimal;
import java.util.Date;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlantElectricityDTO {
    private Long assetId;
    private Date date;
    private BigDecimal electricityPrice;

    public static PlantElectricityDTO convertFromView(PlantAssetView view) {
        PlantElectricityDTO result = new PlantElectricityDTO();
        result.assetId = view.getAssetId();
        result.date = new Date();
        result.electricityPrice = view.getElectricityPrice();
        return result;
    }
}
