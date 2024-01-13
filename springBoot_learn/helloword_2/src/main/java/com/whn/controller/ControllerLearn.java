package com.whn.controller;

import com.whn.common.SimpleResponse;
import com.whn.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: WangHn
 * @Date: 2024/1/12 14:09
 * @Description: 请求映练习
 */
@RestController
@RequestMapping("/learn")
@Slf4j
public class ControllerLearn {


    /**
     * 接收POST请求，用于添加数据
     * @param user
     * @return
     */
    @PostMapping("/post")
    public SimpleResponse post(@RequestBody User user){
        return SimpleResponse.success(user);
    }

    /**
     * 接收GET请求，用于根据id获取数据
     * @param user
     * @return
     */
    @GetMapping("/getException")
    public SimpleResponse getException(){
        ArrayList<Object> objects = null;
        return SimpleResponse.success("传入："+objects.get(1));
    }

    /**
     * 接收GET请求，用于根据id获取数据
     * @param user
     * @return
     */
    @GetMapping("/get/{id}")
    public SimpleResponse get(@PathVariable("id") String user){
        return SimpleResponse.success("传入："+user);
    }

    /**
     * 接收DELETE请求，用于删除数据
     * @param string
     * @return
     */
    @DeleteMapping("/del")
    public SimpleResponse del(@RequestParam("string") String string){
        return SimpleResponse.success("删除："+string);
    }

    /**
     * 接收PUT请求，用于更新数据
     * @param user
     * @return
     */
    @PutMapping("/put")
    public SimpleResponse put(@RequestBody User user){
        return SimpleResponse.success(user);
    }

    /**
     * 在请求中可以又很多的参数 HttpServletRequest 和 HttpServletResponse 是请求体和响应体不需要手动传入我们可以用来做很多事情
     * 当然还可以获取header中的cookie中的·
     * @param userAgent
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/response")
    public SimpleResponse responseParams(@RequestHeader("User-Agent") String userAgent, HttpServletRequest request, HttpServletResponse response){ // 获取请求头信息、请求和响应对象，返回SimpleResponse对象
        // 创建存储结果的HashMap对象
        HashMap<String, Object> result = new HashMap<>();
        result.put("User-Agent", userAgent);
        result.put("request", request.toString());
        result.put("response", response.toString());
        return SimpleResponse.success(result);
    }

    @PostMapping("/fileParam")
    public SimpleResponse responseParams(@RequestParam("file") MultipartFile[] file, User user){
        //请求格式应该是Content-Type:multipart/form-data
        // 创建存储结果的HashMap对象
        HashMap<String, Object> result = new HashMap<>();
        result.put("file", file.length);
        result.put("request", user);
        return SimpleResponse.success(result);
    }

    private static final String CACHE =System.getProperty("user.dir")+ File.separator+"cache"+File.separator;
    /**
     * MultipartFile 自动封装上传过来的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传的信息：email={}，username={}，headerImg={}，photos={}",
                email,username,headerImg.getSize(),photos.length);
        // 创建一个LocalDateTime对象
        LocalDateTime now = LocalDateTime.now();
        // 创建日期时间格式器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        //在文件系统下存放文件模拟上传
        String path = CACHE + now.format(formatter) + File.separator;
        if(!headerImg.isEmpty()){
            //保存到文件服务器，OSS服务器
            transferFile(headerImg, path, "img");
        }
        for (MultipartFile photo : photos) {
            transferFile(photo, path, "photos");
        }
        return "main";
    }

    private void transferFile(MultipartFile photo, String path, String photos) throws IOException {
        if (!photo.isEmpty()) {
            String originalFilename = photo.getOriginalFilename();
            String savePath = path + photos + File.separator + originalFilename;
            File file = new File(savePath);
            file.getParentFile().mkdirs();
            file.createNewFile();
            photo.transferTo(file);
        }
    }




}
