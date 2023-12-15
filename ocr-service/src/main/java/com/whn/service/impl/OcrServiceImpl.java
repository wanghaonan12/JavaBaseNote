package com.whn.service.impl;

import com.whn.service.OcrService;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Wanghn
 * @date 2023/12/15 10:55
 */
@Service
@Slf4j
public class OcrServiceImpl implements OcrService {
    String language = "ch";
    @Override
    public String ocrTransform(MultipartFile file) {
               String modelPath = "D:\\DeskTop\\document\\demo\\myself\\java\\ocr-service\\tessdata";
//        String modelPath = "/root/project/java/tesseract_model";

        Tesseract tessreact = new Tesseract();
        //需要指定训练集 训练集到 https://github.com/tesseract-ocr/tessdata 下载。
        tessreact.setDatapath(modelPath);

        if(language.equals("ch")) {
            //注意  默认是英文识别，如果做中文识别，需要单独设置。
//            tessreact.setLanguage("eng+chi_sim");
//            tessreact.setLanguage("chi_sim");
//            tessreact.setLanguage("eng");
        }
        try {
            File imageFile = new File(file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(file.getInputStream(), imageFile);
            String result = tessreact.doOCR(imageFile);
            log.info(result);
            System.out.println("----------------");
//            String handleResult  =  this.ocr(imageFile,modelPath);
//            log.info(handleResult);
//            return result+"----------------------------------\n\r"+handleResult;
            return result;
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 方法二
     * @param file
     * @param modelPath
     * @return
     */
    private  String ocr(File file,String modelPath) {
        String result = null;
        try {
            double start = System.currentTimeMillis();
            BufferedImage textImage = ImageIO.read(file);
            // 这里对图片黑白处理,增强识别率.这里先通过截图,截取图片中需要识别的部分
            textImage = ImageHelper.convertImageToGrayscale(textImage);
            // 图片锐化
            textImage = ImageHelper.convertImageToBinary(textImage);
            // 图片放大倍数,增强识别率(很多图片本身无法识别,放大5倍时就可以轻易识,但是考滤到客户电脑配置低,针式打印机打印不连贯的问题,这里就放大5倍)
            textImage = ImageHelper.getScaledInstance(textImage, textImage.getWidth() * 1, textImage.getHeight() * 1);

            textImage = ImageHelper.convertImageToBinary(textImage);
            String saveImgPath = "D:\\DeskTop\\test.png";
//            String saveImgPath = "D:\\software\\ocr-tesseract\\img_tem\\temp.img";
            ImageIO.write(textImage, "png", new File(saveImgPath));

            Tesseract instance = new Tesseract();
            //设置训练库的位置
//            String modelPath = "/root/project/java/tesseract_model";
            instance.setDatapath(modelPath);
            //中文识别
            instance.setLanguage("chi_sim");
            result = instance.doOCR(textImage);
            double end = System.currentTimeMillis();
            System.out.println("耗时" + (end - start) / 1000 + " s");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
