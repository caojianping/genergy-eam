package net.gichain.genergy.eam.grpc.server.serverservice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.database.entity.PlantAssetEnergyView;
import net.gichain.genergy.eam.grpc.lib.AssetIdRequest;
import net.gichain.genergy.eam.grpc.lib.EnergyServiceGrpc;
import net.gichain.genergy.eam.grpc.lib.EnergyTrendRequest;
import net.gichain.genergy.eam.grpc.lib.Result;
import net.gichain.genergy.eam.grpc.server.GrpcResponse;
import net.gichain.genergy.eam.grpc.server.dto.EnergyTrendDTO;
import net.gichain.genergy.eam.grpc.server.dto.EnergyYesterdayDTO;
import net.gichain.genergy.eam.grpc.server.service.IPlantAssetEnergyViewService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@GrpcService
public class EnergyServerService extends EnergyServiceGrpc.EnergyServiceImplBase {
    @Autowired
    private IPlantAssetEnergyViewService plantAssetEnergyViewService;

    /**
     * 获取电站昨日发电量
     *
     * @param request          请求参数
     * @param responseObserver 响应流
     */
    @Override
    public void getYesterdayEnergy(AssetIdRequest request, StreamObserver<Result> responseObserver) {
        int assetId = request.getAssetId();
        QueryWrapper<PlantAssetEnergyView> wrapper = new QueryWrapper<PlantAssetEnergyView>();
        wrapper.eq("assetId", assetId);
        PlantAssetEnergyView plantAssetEnergyView = plantAssetEnergyViewService.getOne(wrapper);
        if (plantAssetEnergyView == null) {
            GrpcResponse.failure(CodeEnum.ENERGY_INEXISTENCE, responseObserver);
        } else {
            EnergyYesterdayDTO result = EnergyYesterdayDTO.convertFromView(plantAssetEnergyView);
            GrpcResponse.success(result, responseObserver);
        }
    }

    /**
     * 获取发电量走势
     *
     * @param request          请求参数
     * @param responseObserver 响应流
     */
    @Override
    public void getEnergyTrend(EnergyTrendRequest request, StreamObserver<Result> responseObserver) {
        int assetId = request.getAssetId();
        int type = request.getType();

        QueryWrapper<PlantAssetEnergyView> wrapper = new QueryWrapper<PlantAssetEnergyView>();
        wrapper.eq("assetId", assetId);
        wrapper.orderByAsc("date");
        List<PlantAssetEnergyView> plantAssetEnergyViews = plantAssetEnergyViewService.list(wrapper);

        List<EnergyTrendDTO> result = EnergyTrendDTO.convertFromViews(plantAssetEnergyViews);
        GrpcResponse.success(result, responseObserver);
    }
}
