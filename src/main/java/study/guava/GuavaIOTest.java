package study.guava;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuavaIOTest {


    public static class FileUtil {
        /**
         * 文件读取
         */
        public static List<String> readFromFile(String fileName) {
            List<String> lines = new ArrayList<String>();

            try {
                File file = new File(fileName);
                lines = Files.readLines(file, Charsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return lines;
        }


        /**
         * 向文件中写入字节流
         */
        public static void write2File(String fileName, String contents) {
            File newFile = new File(fileName);
            try {

                Files.append(contents, newFile, Charsets.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
