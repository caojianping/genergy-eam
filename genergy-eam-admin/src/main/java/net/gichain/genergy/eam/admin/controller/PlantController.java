package net.gichain.genergy.eam.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.admin.controller.dto.PlantDTO;
import net.gichain.genergy.eam.admin.service.IPlantAssetViewService;
import net.gichain.genergy.eam.common.annotation.TokenAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/plant")
@RestController
public class PlantController extends BaseController {
    @Autowired
    private IPlantAssetViewService plantAssetViewService;

    @TokenAnnotation
    @GetMapping("/page/{current}/{size}")
    @ResponseBody
    public IPage<PlantDTO> page(
            @PathVariable(name = "current") int current,
            @PathVariable(name = "size") int size,
            @RequestParam(required = false) String putawaySerial,
            @RequestParam(required = false) String plantName,
            @RequestParam(required = false) String putawayStartTime,
            @RequestParam(required = false) String putawayEndTime
    ) {
        log.info(String.format("/plant/page current, size: %d %d", current, size));
        log.info(String.format("/plant/page putawaySerial,plantName,putawayStartTime,putawayEndTime: %s %s %s %s", putawaySerial, plantName, putawayStartTime, putawayEndTime));
        return plantAssetViewService.pagePlants(current, size, putawaySerial, plantName, putawayStartTime, putawayEndTime);
    }
}
