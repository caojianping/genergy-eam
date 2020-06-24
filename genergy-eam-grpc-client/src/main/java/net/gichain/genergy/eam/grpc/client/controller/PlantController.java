package net.gichain.genergy.eam.grpc.client.controller;

import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.grpc.client.clientservice.PlantClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/grpc/plant")
@RestController
public class PlantController {
    @Autowired
    private PlantClientService plantClientService;

    @GetMapping("/electricityPrice/{assetId}")
    @ResponseBody
    public String getElectricityPrice(@PathVariable(name = "assetId") int assetId) {
        return plantClientService.getElectricityPrice(assetId);
    }

    @GetMapping("/detail/{assetId}")
    @ResponseBody
    public String getPlantDetail(@PathVariable(name = "assetId") int assetId) {
        return plantClientService.getPlantDetail(assetId);
    }
}
