package net.gichain.genergy.eam.grpc.server.serverservice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.util.DateUtils;
import net.gichain.genergy.eam.database.entity.PlantAssetSplitView;
import net.gichain.genergy.eam.database.entity.PlantAssetView;
import net.gichain.genergy.eam.grpc.lib.AssetIdRequest;
import net.gichain.genergy.eam.grpc.lib.PlantServiceGrpc;
import net.gichain.genergy.eam.grpc.lib.Result;
import net.gichain.genergy.eam.grpc.server.GrpcResponse;
import net.gichain.genergy.eam.grpc.server.dto.PlantElectricityDTO;
import net.gichain.genergy.eam.grpc.server.service.IPlantAssetSplitViewService;
import net.gichain.genergy.eam.grpc.server.service.IPlantAssetViewService;
import net.gichain.genergy.vo.plant.PlantOverview;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@GrpcService
public class PlantServerService extends PlantServiceGrpc.PlantServiceImplBase {
    @Autowired
    private IPlantAssetViewService plantAssetViewService;

    @Autowired
    private IPlantAssetSplitViewService plantAssetSplitViewService;

    /**
     * 获取电站上网电价
     *
     * @param request          请求参数
     * @param responseObserver 响应流
     */
    @Override
    public void getElectricityPrice(AssetIdRequest request, StreamObserver<Result> responseObserver) {
        Long assetId = request.getAssetId();
        log.info(String.format("获取电站上网电价 assetId: %d", assetId));

        QueryWrapper<PlantAssetView> wrapper = new QueryWrapper<PlantAssetView>();
        wrapper.eq("asset_id", assetId);
        PlantAssetView plantAssetView = plantAssetViewService.getOne(wrapper);
        log.info(String.format("获取电站上网电价 view: %s", plantAssetView));
        if (plantAssetView == null) {
            GrpcResponse.failure(CodeEnum.ASSET_INEXISTENCE, responseObserver);
            return;
        } else {
            PlantElectricityDTO result = PlantElectricityDTO.convertFromView(plantAssetView);
            log.info(String.format("获取电站上网电价 result: %s", result));
            GrpcResponse.success(result, responseObserver);
        }
    }

    /**
     * 获取电站详情数据
     *
     * @param request          请求参数
     * @param responseObserver 响应流
     */
    @Override
    public void getPlantDetail(AssetIdRequest request, StreamObserver<Result> responseObserver) {
        Long assetId = request.getAssetId();
        log.info(String.format("获取电站详情数据 assetId: %d", assetId));

        QueryWrapper<PlantAssetSplitView> wrapper = new QueryWrapper<PlantAssetSplitView>();
        wrapper.eq("asset_id", assetId);
        PlantAssetSplitView plantAssetSplitView = plantAssetSplitViewService.getOne(wrapper);
        log.info(String.format("获取电站详情数据 view: %s", plantAssetSplitView));
        if (plantAssetSplitView == null) {
            GrpcResponse.failure(CodeEnum.ASSET_INEXISTENCE, responseObserver);
        } else {
            PlantOverview result = convertToPlantOverview(plantAssetSplitView);
            log.info(String.format("获取电站详情数据 result: %s", result));
            GrpcResponse.success(result, responseObserver);
        }
    }

    private static PlantOverview convertToPlantOverview(PlantAssetSplitView view) {
        PlantOverview result = new PlantOverview();
        result.setImageUrl(view.getImgs());
        result.setInstallationAddress(String.format("%s%s%s%s", view.getProvince(), view.getCity(), view.getDistrict(), view.getAddress()));
        result.setCoordinate(view.getLongitude() + "," + view.getLatitude());
        result.setInstalledCapacity(view.getInstalledPower().toString());
        result.setCapacityUnit("kW");
        result.setTotalShares(view.getTotalShares());
        result.setEstimatedAnnualEnergy(view.getEstimatedAnnualEnergy().toString());
        result.setEstimatedAnnualEnergyUnit("kWh");
        result.setElectricityPrice(view.getElectricityPrice().toString());
        result.setGridConnectedDate(DateUtils.dateToStr(view.getGridConnectedDate(), "yyyy-MM-dd"));
        result.setInstallationDate("");
        result.setResidualEnergyTerm(view.getResidualEnergyTerm());
        result.setInverterSupplier(view.getInverterSupplier());
        result.setComponentSupplier(view.getComponentSupplier());
        result.setComponentModel(view.getComponentModel());
        result.setOperatingCompany("合肥达链");
        result.setConstructionCompany(view.getConstructionCompany());
        result.setOriginalOwner(view.getCompanyName());
        return result;
    }
}
