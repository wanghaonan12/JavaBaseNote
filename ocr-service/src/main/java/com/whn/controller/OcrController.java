package com.whn.controller;

import com.whn.service.OcrService;
import com.whn.service.impl.OcrServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @author Wanghn
 * @date 2023/12/15 10:42
 */
@RestController()
@RequestMapping("/ocr")
public class OcrController {

    @Autowired
    private OcrService ocrService;
    @PostMapping("/")
    private String ocrTransform(@RequestParam("file") MultipartFile file) throws IOException {
        return ocrService.ocrTransform(file);
    }
}
