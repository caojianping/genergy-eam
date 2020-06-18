package net.gichain.genergy.eam.grpc.server.serverservice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.database.entity.PlantAssetSplitView;
import net.gichain.genergy.eam.database.entity.PlantAssetView;
import net.gichain.genergy.eam.grpc.lib.AssetIdRequest;
import net.gichain.genergy.eam.grpc.lib.PlantServiceGrpc;
import net.gichain.genergy.eam.grpc.lib.Result;
import net.gichain.genergy.eam.grpc.server.GrpcResponse;
import net.gichain.genergy.eam.grpc.server.dto.PlantDetailDTO;
import net.gichain.genergy.eam.grpc.server.dto.PlantElectricityDTO;
import net.gichain.genergy.eam.grpc.server.service.IPlantAssetSplitViewService;
import net.gichain.genergy.eam.grpc.server.service.IPlantAssetViewService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class PlantServerService extends PlantServiceGrpc.PlantServiceImplBase {
    @Autowired
    private IPlantAssetViewService plantAssetViewService;

    @Autowired
    private IPlantAssetSplitViewService plantAssetSplitViewService;

    /**
     * 获取电站上网电价
     *
     * @param request 请求参数
     * @param responseObserver 响应流
     */
    @Override
    public void getElectricityPrice(AssetIdRequest request, StreamObserver<Result> responseObserver) {
        int assetId = request.getAssetId();
        QueryWrapper<PlantAssetView> wrapper = new QueryWrapper<PlantAssetView>();
        wrapper.eq("assetId", assetId);
        PlantAssetView plantAssetView = plantAssetViewService.getOne(wrapper);
        if (plantAssetView == null) {
            GrpcResponse.failure(CodeEnum.ASSET_INEXISTENCE, responseObserver);
        } else {
            PlantElectricityDTO result = PlantElectricityDTO.convertFromView(plantAssetView);
            GrpcResponse.success(result, responseObserver);
        }
    }

    /**
     * 获取电站详情数据
     *
     * @param request 请求参数
     * @param responseObserver 响应流
     */
    @Override
    public void getPlantDetail(AssetIdRequest request, StreamObserver<Result> responseObserver) {
        int assetId = request.getAssetId();
        QueryWrapper<PlantAssetSplitView> wrapper = new QueryWrapper<PlantAssetSplitView>();
        wrapper.eq("assetId", assetId);
        PlantAssetSplitView plantAssetSplitView = plantAssetSplitViewService.getOne(wrapper);
        if (plantAssetSplitView == null) {
            GrpcResponse.failure(CodeEnum.ASSET_INEXISTENCE, responseObserver);
        } else {
            PlantDetailDTO result = PlantDetailDTO.convertFromView(plantAssetSplitView);
            GrpcResponse.success(result, responseObserver);
        }
    }
}
