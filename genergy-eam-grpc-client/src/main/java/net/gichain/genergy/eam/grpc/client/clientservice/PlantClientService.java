package net.gichain.genergy.eam.grpc.client.clientservice;

import com.google.protobuf.InvalidProtocolBufferException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.gichain.genergy.eam.grpc.lib.AssetIdRequest;
import net.gichain.genergy.eam.grpc.lib.PlantServiceGrpc;
import net.gichain.genergy.eam.grpc.lib.Result;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PlantClientService {

    @GrpcClient("genergy-eam-grpc-server")
    private PlantServiceGrpc.PlantServiceBlockingStub plantServiceBlockingStub;

    public String getElectricityPrice(int assetId) {
        AssetIdRequest request = AssetIdRequest.newBuilder()
                .setAssetId(assetId).build();
        Result result = plantServiceBlockingStub.getElectricityPrice(request);
        log.info(String.format("PlantClientService.getElectricityPrice assetId,result: %d %s", assetId, result));
        return result.getData();
    }

    public String getPlantDetail(int assetId) {
        AssetIdRequest request = AssetIdRequest.newBuilder()
                .setAssetId(assetId).build();
        Result result = plantServiceBlockingStub.getPlantDetail(request);
        log.info(String.format("PlantClientService.getPlantDetail assetId,result: %d %s", assetId, result));
        return result.getData();
    }
}

