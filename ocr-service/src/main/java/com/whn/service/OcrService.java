package com.whn.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Wanghn
 * @date 2023/12/15 10:54
 */
public interface OcrService {
    String ocrTransform(MultipartFile file);
}
