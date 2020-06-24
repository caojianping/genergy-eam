package net.gichain.genergy.eam.admin.controller;

import lombok.extern.slf4j.Slf4j;
import net.gichain.genergy.eam.admin.enums.CertFileTypeEnum;
import net.gichain.genergy.eam.admin.enums.LegalFileTypeEnum;
import net.gichain.genergy.eam.admin.enums.UploadTypeEnum;
import net.gichain.genergy.eam.common.annotation.TokenAnnotation;
import net.gichain.genergy.eam.common.enums.CodeEnum;
import net.gichain.genergy.eam.common.exception.BusinessException;
import net.gichain.genergy.eam.common.util.UUIDUtils;
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
    @Value("${upload-path}")
    private String uploadPath;

    @TokenAnnotation
    @PostMapping("/cert/{fileType}")
    @ResponseBody
    public String uploadCert(
            @PathVariable(name = "fileType") CertFileTypeEnum fileType,
            @RequestParam("file") MultipartFile file
    ) throws BusinessException {
        log.info(String.format("/upload/cert fileType: %d %s", fileType, file));
        if (file.isEmpty()) {
            throw new BusinessException(CodeEnum.FILE_REQUIRED);
        }

        String prefix = UploadTypeEnum.CERT_UPLOAD + "_" + fileType;
        return this.handleFile(file, prefix);
    }

    @TokenAnnotation
    @PostMapping("/legal/{fileType}")
    @ResponseBody
    public String uploadLegal(
            @PathVariable(name = "fileType") LegalFileTypeEnum fileType,
            @RequestParam("file") MultipartFile file
    ) throws BusinessException {
        log.info(String.format("/upload/legal fileType: %d %s", fileType, file));
        if (file.isEmpty()) {
            throw new BusinessException(CodeEnum.FILE_REQUIRED);
        }

        String prefix = UploadTypeEnum.LEGAL_UPLOAD + "_" + fileType;
        return this.handleFile(file, prefix);
    }

    @TokenAnnotation
    @PostMapping("/imgs")
    @ResponseBody
    public List<String> uploadImgs(@RequestParam("file") MultipartFile[] files) throws BusinessException {
        log.info(String.format("/upload/imgs files: %s", files));
        if (files.length <= 0) {
            throw new BusinessException(CodeEnum.FILE_REQUIRED);
        }

        String prefix = UploadTypeEnum.IMG_UPLOAD + "_";
        List<String> imgs = new ArrayList<>();
        for (MultipartFile file : files) {
            String fileName = this.handleFile(file, prefix);
            imgs.add(fileName);
        }
        return imgs;
    }

    private String handleFile(MultipartFile file, String prefix) throws BusinessException {
        String guid = UUIDUtils.randomUUID();
        String originName = file.getOriginalFilename();
        String ext = originName.substring(originName.lastIndexOf("."));
        String fileName = this.uploadPath + prefix + "_" + guid + "." + ext;
        try {
            file.transferTo(new File(fileName));
        } catch (IOException exception) {
            throw new BusinessException(CodeEnum.FILE_ERROR);
        }
        return fileName;
    }
}
