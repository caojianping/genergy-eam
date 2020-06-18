package net.gichain.genergy.eam.grpc.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.gichain.genergy.eam.database.entity.PlantAssetSplitView;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlantDetailDTO {
    private Long assetId;
    private String imageUrl;
    private String installationAddress;
    private String coordinate;
    private BigDecimal installedCapacity;
    private String capacityUnit;
    private Integer totalShares;
    private BigDecimal estimatedAnnualEnergy;
    private String estimatedAnnualEnergyUnit;
    private BigDecimal electricityPrice;
    private LocalDate gridConnectedDate;
    private LocalDate installationDate;
    private Integer residualEnergyTerm;
    private String inverterSupplier;
    private String componentSupplier;
    private String componentModel;
    private String operatingCompany;
    private String constructionCompany;
    private String originalOwner;
    private List<ContractDTO> contractList;

    @Data
    public class ContractDTO {
        private String contractName;
        private String url;
    }

    public static PlantDetailDTO convertFromView(PlantAssetSplitView view) {
        PlantDetailDTO result = new PlantDetailDTO();
        result.assetId = view.getAssetId();
        result.imageUrl = view.getImgs();
        result.installationAddress = String.format("%s%s%s%s", view.getProvince(), view.getCity(), view.getDistrict(), view.getAddress());
        result.coordinate = view.getLongitude() + "," + view.getLatitude();
        result.installedCapacity = view.getInstalledPower();
        result.capacityUnit = "kW";
        result.totalShares = view.getTotalShares();
        result.estimatedAnnualEnergy = view.getEstimatedAnnualEnergy();
        result.estimatedAnnualEnergyUnit = "kWh";
        result.electricityPrice = view.getElectricityPrice();
        result.gridConnectedDate = view.getGridConnectedDate();
        result.installationDate = null;
        result.residualEnergyTerm = view.getResidualEnergyTerm();
        result.inverterSupplier = view.getInverterSupplier();
        result.componentSupplier = view.getComponentSupplier();
        result.componentModel = view.getComponentModel();
        result.operatingCompany = "合肥达链";
        result.constructionCompany = view.getConstructionCompany();
        result.originalOwner = view.getCompanyName();
        return result;
    }
}
