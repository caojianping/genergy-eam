package net.gichain.genergy.eam.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.admin.controller.dto.AssetDTO;
import net.gichain.genergy.eam.admin.controller.vo.AssetAuditVO;
import net.gichain.genergy.eam.admin.controller.vo.AssetVO;
import net.gichain.genergy.eam.admin.service.IAssetService;
import net.gichain.genergy.eam.admin.service.IPlantAssetViewService;
import net.gichain.genergy.eam.common.annotation.TokenAnnotation;
import net.gichain.genergy.eam.common.exception.BusinessException;
import net.gichain.genergy.eam.common.exception.TokenException;
import net.gichain.genergy.eam.database.entity.PlantAssetView;
import net.gichain.genergy.eam.database.enums.AssetStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@Slf4j
@RequestMapping("/asset")
@RestController
public class AssetController extends BaseController {
    @Autowired
    private IPlantAssetViewService plantAssetViewService;

    @Autowired
    private IAssetService assetService;

    @TokenAnnotation
    @GetMapping("/page/{current}/{size}")
    @ResponseBody
    public IPage<AssetDTO> pageAssets(
            @PathVariable(name = "current") int current,
            @PathVariable(name = "size") int size,
            @RequestParam(required = false) String putawaySerial,
            @RequestParam(required = false) String plantName,
            @RequestParam(required = false) String submitter,
            @RequestParam(required = false) String auditor,
            @RequestParam(required = false) Integer status
    ) {
        log.info(String.format("/asset/page current, size: %d %d", current, size));
        log.info(String.format("/asset/page putawaySerial,plantName,submitter,auditor,stauts: %s %s %s %s %s",
                putawaySerial, plantName, submitter, auditor, status));
        return plantAssetViewService.pageAssets(current, size, putawaySerial, plantName, submitter, auditor, status);
    }

    @TokenAnnotation
    @GetMapping("/detail/{id}")
    @ResponseBody
    public PlantAssetView detail(@PathVariable(name = "id") long id) {
        log.info(String.format("/asset/detail id: %d", id));
        return plantAssetViewService.getDetail(id);
    }

    @TokenAnnotation
    @PostMapping("/save")
    @ResponseBody
    public boolean save(@RequestBody @Valid AssetVO assetVO) throws BusinessException, TokenException {
        Integer userId = this.getUserId();
        log.info(String.format("/asset/save userId, assetVO: %d %s", userId, assetVO));
        return assetService.saveCombinedData(userId, assetVO, false);
    }

    @TokenAnnotation
    @PostMapping("/submit")
    @ResponseBody
    public boolean submit(@RequestBody @Valid AssetVO assetVO) throws BusinessException, TokenException {
        Integer userId = this.getUserId();
        log.info(String.format("/asset/submit userId, assetVO: %d %s", userId, assetVO));
        return assetService.saveCombinedData(userId, assetVO, true);
    }

    @TokenAnnotation
    @PostMapping("/setStatus")
    @ResponseBody
    public boolean setStatus(@RequestBody @Valid AssetAuditVO assetAuditVO) throws BusinessException, TokenException {
        Integer userId = this.getUserId();
        log.info(String.format("/asset/setStatus userId, id, assetAuditVO: %d %s", userId, assetAuditVO));
        return assetService.setStatus(userId, assetAuditVO);
    }
}
