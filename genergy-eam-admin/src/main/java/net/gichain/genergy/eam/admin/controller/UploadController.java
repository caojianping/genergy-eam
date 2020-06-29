package net.gichain.genergy.eam.admin.controller;

import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.admin.enums.LegalFileTypeEnum;
import net.gichain.genergy.eam.admin.enums.UploadTypeEnum;
import net.gichain.genergy.eam.admin.service.IPlantAssetViewService;
import net.gichain.genergy.eam.common.annotation.TokenAnnotation;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.exception.BusinessException;
import net.gichain.genergy.eam.common.util.ArrayUtils;
import net.gichain.genergy.eam.common.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Validated
@Slf4j
@RequestMapping("/upload")
@RestController
public class UploadController extends BaseController {
    @Value("${upload-path.files}")
    private String filePath;

    @Value("${upload-path.temp}")
    private String tempPath;

    @Autowired
    private IPlantAssetViewService plantAssetViewService;

    @TokenAnnotation
    @PostMapping("/cert/{fileType}")
    @ResponseBody
    public String uploadCert(
            @PathVariable(name = "fileType") int fileType,
            @RequestParam(required = false) Long assetId,
            @RequestParam("file") MultipartFile file
    ) throws BusinessException {
        log.info(String.format("/upload/cert fileType,assetId,file: %s %d %s", fileType, assetId, file));

        if (file.isEmpty()) {
            throw new BusinessException(CodeEnum.FILE_REQUIRED);
        }

        String prefix = UploadTypeEnum.CERT_UPLOAD.getValue() + "_" + fileType + "_";
        if (assetId == null) {
            // 新增证件文件
            return this.addFile(file, this.filePath, prefix);
        } else {
            // 修改证件文件
            String[] certFiles = plantAssetViewService.getStaticsByAssetId(assetId, UploadTypeEnum.CERT_UPLOAD);
            String certFile = ArrayUtils.findItem(certFiles, prefix);
            return this.saveFile(file, this.filePath, certFile);
        }
    }

    @TokenAnnotation
    @PostMapping("/legal/{fileType}")
    @ResponseBody
    public String uploadLegal(
            @PathVariable(name = "fileType") int fileType,
            @RequestParam(required = false) Long assetId,
            @RequestParam("file") MultipartFile file
    ) throws BusinessException {
        log.info(String.format("/upload/legal fileType,assetId,file: %s %d %s", fileType, assetId, file));

        if (file.isEmpty()) {
            throw new BusinessException(CodeEnum.FILE_REQUIRED);
        }

        String prefix = UploadTypeEnum.LEGAL_UPLOAD.getValue() + "_" + fileType + "_";
        if (assetId == null) {
            // 新增证件文件
            return this.addFile(file, this.filePath, prefix);
        } else {
            // 修改证件文件
            String[] legalFiles = plantAssetViewService.getStaticsByAssetId(assetId, UploadTypeEnum.LEGAL_UPLOAD);
            String legalFile = ArrayUtils.findItem(legalFiles, prefix);
            return this.saveFile(file, this.filePath, legalFile);
        }
    }

    @TokenAnnotation
    @PostMapping("/imgs")
    @ResponseBody
    public List<String> uploadImgs(
            @RequestParam(required = false) Long assetId,
            @RequestParam("files") MultipartFile[] files
    ) throws BusinessException {
        log.info(String.format("/upload/imgs assetId,files: %d %s", assetId, files));

        if (files.length <= 0) {
            throw new BusinessException(CodeEnum.FILE_REQUIRED);
        }

        String prefix = UploadTypeEnum.IMG_UPLOAD.getValue() + "_";
        // 新增图片文件
        List<String> imgs = new ArrayList<>();
        for (MultipartFile file : files) {
            String fileName = this.addFile(file, this.filePath, prefix);
            imgs.add(fileName);
        }
        return imgs;
    }

    private String addFile(MultipartFile file, String path, String prefix) throws BusinessException {
        String guid = UUIDUtils.randomUUID();
        String originName = file.getOriginalFilename();
        String ext = originName.substring(originName.lastIndexOf("."));
        String fileName = prefix + guid + ext;
        return this.saveFile(file, path, fileName);
    }

    private String saveFile(MultipartFile file, String path, String fileName) throws BusinessException {
        try {
            file.transferTo(new File(path + fileName));
        } catch (IOException exception) {
            log.info(String.format("saveFile exception: %s", exception));
            throw new BusinessException(CodeEnum.FILE_ERROR);
        }
        return fileName;
    }
}
