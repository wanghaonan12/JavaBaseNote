package com.whn.File.IO;


import org.springframework.context.annotation.Lazy;

import java.io.*;
import java.util.Objects;
import java.util.stream.Stream;


/**
 * @Author WHN
 * @Date 2023/7/12 17:10
 * @description 文件IO字节流复制文件流的操作
 * @Version 1.0
 */
public class Code_01_IO {
    public static void main(String[] args) throws Exception {
//        读取文件位置
        File file = new File("java8/src/main/java/com/whn/File/IO/IOFile.txt");
//        复制文件位置
        File copy_file = new File("java8/src/main/java/com/whn/File/IO/IOFile_cop2.txt");
//        文件不存则新建
        if (!copy_file.exists()) {
            try {
                copy_file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
//        输入流
        InputStream in = new FileInputStream(file);
        InputStreamReader is = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(is);
//        输出流
        OutputStream ou = new FileOutputStream(copy_file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(ou);
        BufferedWriter bw = new BufferedWriter(outputStreamWriter);
//        缓冲区
        char[] c = new char[10 * 2];
        int read = br.read(c);
        while (read != -1) {
            System.out.println(c);
            bw.write(c, 0, read);
            read = br.read(c);
        }
//       逆序关闭流
        bw.close();
        outputStreamWriter.close();
        ou.close();
        br.close();
        is.close();
        in.close();
    }
}
