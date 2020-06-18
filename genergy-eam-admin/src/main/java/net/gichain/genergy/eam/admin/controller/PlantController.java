package net.gichain.genergy.eam.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.admin.service.IPlantService;
import net.gichain.genergy.eam.common.annotations.TokenAnnotation;
import net.gichain.genergy.eam.common.exceptions.BusinessException;
import net.gichain.genergy.eam.database.entity.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/plant")
@RestController
public class PlantController {
    @Autowired
    private IPlantService plantService;

    @TokenAnnotation
    @GetMapping("/page/{pageNum}/{pageSize}")
    @ResponseBody
    public IPage<Plant> page(
            @PathVariable(name = "pageNum") int pageNum,
            @PathVariable(name = "pageSize") int pageSize
    ) {
        Page<Plant> page = new Page<Plant>(pageNum, pageSize);
        return plantService.page(page);
    }

    @TokenAnnotation
    @GetMapping("/detail/{id}")
    @ResponseBody
    public Plant detail(@PathVariable(name = "id") int id) {
        log.info(String.format("/plant/detail args: %d", id));
        return plantService.getById(id);
    }

    @TokenAnnotation
    @PostMapping("/add")
    @ResponseBody
    public boolean add() throws BusinessException {
        return true;
    }

    @TokenAnnotation
    @PostMapping("/update")
    @ResponseBody
    public boolean update() throws BusinessException {
        return true;
    }

    @TokenAnnotation
    @PostMapping("/remove")
    @ResponseBody
    public boolean remove() throws BusinessException {
        return true;
    }
}
