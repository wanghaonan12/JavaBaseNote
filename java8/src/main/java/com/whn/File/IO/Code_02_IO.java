package com.whn.File.IO;


import java.io.*;
import java.util.Objects;


/**
 * @Author WHN
 * @Date 2023/7/12 17:10
 * @description 文件IO字符流复制文件流的操作
 * @Version 1.0
 */
public class Code_02_IO {
    public static void main(String[] args) throws Exception {
//        读取文件位置
        File file = new File("java8/src/main/java/com/whn/File/IO/IOFile.txt");
//        复制文件位置
        File copy_file = new File("java8/src/main/java/com/whn/File/IO/IOFile_copy.txt");
//        文件不存则新建
        if (!copy_file.exists()) {
            try {
                copy_file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
//        输入流
        InputStream is = null;
//        输出流
        OutputStream os = null;
//        缓冲输入流
        BufferedInputStream bufferedInputStream = null;
//        缓冲输出流
        BufferedOutputStream bufferedOutputStream = null;
        is = new FileInputStream(file);
        bufferedInputStream = new BufferedInputStream(is);
        os = new FileOutputStream(copy_file);
        bufferedOutputStream = new BufferedOutputStream(os);
//        缓冲数组
        byte[] b = new byte[8*4];
        int read = bufferedInputStream.read(b);
        while (read != -1) {
//            输出流输出
            bufferedOutputStream.write(b, 0, read);
//            输入流读取文件
            read = bufferedInputStream.read(b);
        }
//      逆序关闭流操作
        if (!Objects.isNull(bufferedOutputStream)) {
            bufferedOutputStream.close();
        }
        if (!Objects.isNull(os)) {
            os.close();
        }
        if (!Objects.isNull(bufferedInputStream)) {
            bufferedInputStream.close();
        }
        if (!Objects.isNull(is)) {
            is.close();
        }
    }
}
