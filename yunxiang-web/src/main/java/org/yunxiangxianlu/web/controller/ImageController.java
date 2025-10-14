package org.yunxiangxianlu.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yunxiangxianlu.common.dto.res.Result;
import org.yunxiangxianlu.common.exception.BusinessException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.yunxiangxianlu.common.exception.ErrorCode.*;

@RequestMapping("/image")
@RestController
public class ImageController {

    private static final String UPLOAD_DIR = "uploads/";
    private static final Logger log = LoggerFactory.getLogger(ImageController.class);

    // 创建上传目录
    static {
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
    }

    @PostMapping("/upload")
    @ResponseBody
    public Result<String> uploadImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new BusinessException(FILE_NOT_SELECTED);
        }

        try {
            // 检查文件类型
            String contentType = file.getContentType();
            if (contentType == null || !contentType.startsWith("image/")) {
                throw new BusinessException(FILE_TYPE_NOT_SUPPORTED);
            }

            // 生成唯一文件名，避免冲突
            String originalFilename = file.getOriginalFilename();
            String extension = StringUtils.getFilenameExtension(originalFilename);
            String newFilename = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")) +
                    "_" + System.currentTimeMillis() + "." + extension;

            Path path = Paths.get(UPLOAD_DIR + newFilename);
            Files.write(path, file.getBytes());

            // 返回访问URL
            String imageUrl = "/images/" + newFilename;
            return Result.success(imageUrl);

        } catch (IOException e) {
            log.error("文件上传失败: " + e.getMessage(), e);
            return Result.error(FILE_UPLOAD_FAILED, MDC.get("traceId"));
        }
    }

//    // 提供图片访问接口（虽然通过静态资源配置已可访问，但保留此接口作为备用）
//    @GetMapping("/images/{filename:.+}")
//    @ResponseBody
//    public Result<byte[]> getImage(@PathVariable String filename) throws IOException {
//        Path imagePath = Paths.get(UPLOAD_DIR + filename);
//        if (!Files.exists(imagePath)) {
//            throw new RuntimeException("图片不存在");
//        }
//        return Result.success(Files.readAllBytes(imagePath));
//    }

    @GetMapping("/images/{filename}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        try {
            Path filePath = Paths.get("./uploads/", filename).toAbsolutePath().normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_PNG) // 可根据文件类型动态判断
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
