package net.gichain.genergy.eam.grpc.client.controller;

import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.grpc.client.clientservice.EnergyClientService;
import net.gichain.genergy.eam.grpc.client.clientservice.PlantClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/grpc/energy")
@RestController
public class EnergyController {
    @Autowired
    private EnergyClientService energyClientService;

    @GetMapping("/yesterday/{assetId}")
    @ResponseBody
    public String getYesterdayEnergy(@PathVariable(name = "assetId") int assetId) {
        return energyClientService.getYesterdayEnergy(assetId);
    }

    @GetMapping("/trend/{assetId}/{type}")
    @ResponseBody
    public String getEnergyTrend(
            @PathVariable(name = "assetId") int assetId,
            @PathVariable(name = "type") int type
    ) {
        return energyClientService.getEnergyTrend(assetId, type);
    }
}
