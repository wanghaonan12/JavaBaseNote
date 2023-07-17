package com.whn.File.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author WHN
 * @Date 2023/7/12 17:24
 * @description
 * @Version 1.0
 */
public class Code_00_init {
    public static void main(String[] args) throws IOException {
        File file = new File("java8/src/main/java/com/whn/File/IO/IOFile.txt");
        File file2 = new File("java8/src/main/java/com/whn/File/document_object_txt.txt");
        List<String> content = Arrays.asList("枫桥夜泊","【作者】张继 【朝代】唐","月落乌啼霜满天，江枫渔火对愁眠。","姑苏城外寒山寺，夜半钟声到客船。");
        FileWriter fileWriter = new FileWriter(file);
        FileWriter fileWriter2 = new FileWriter(file2);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
        content.forEach(s -> {
            try {
                bufferedWriter2.write(s);
                bufferedWriter.write(s);
                bufferedWriter.write("\n");
                bufferedWriter2.write("\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bufferedWriter.close();
        bufferedWriter2.close();
    }
}
