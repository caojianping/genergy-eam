package net.gichain.genergy.eam.grpc.client.clientservice;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.gichain.genergy.eam.grpc.lib.*;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EnergyClientService {

    @GrpcClient("genergy-eam-grpc-server")
    private EnergyServiceGrpc.EnergyServiceBlockingStub energyServiceBlockingStub;

    public String getYesterdayEnergy(int assetId) {
        AssetIdRequest request = AssetIdRequest.newBuilder()
                .setAssetId(assetId).build();
        Result result = energyServiceBlockingStub.getYesterdayEnergy(request);
        log.info(String.format("EnergyClientService.getYesterdayEnergy assetId,result: %d %s", assetId, result));
        return result.getData();
    }

    public String getEnergyTrend(int assetId, int type) {
        EnergyTrendRequest request = EnergyTrendRequest.newBuilder()
                .setAssetId(assetId).setType(type).build();
        Result result = energyServiceBlockingStub.getEnergyTrend(request);
        log.info(String.format("EnergyClientService.getEnergyTrend assetId,type,result: %d %s", assetId, type, result));
        return result.getData();
    }
}

