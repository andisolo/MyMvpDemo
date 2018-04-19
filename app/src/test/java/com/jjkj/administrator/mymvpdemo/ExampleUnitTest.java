package com.jjkj.administrator.mymvpdemo;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private FileWriter mWriter;
    private File mFile;

    @Test
    public void addition_isCorrect() throws IOException {
        mFile = new File("code.txt");
        System.out.println(mFile.getPath());
        mWriter = new FileWriter(mFile);
        readFile("D:\\securitycheck");
    }

    private void readFile(String path) throws IOException {
        File file = new File(path);
        File[] tempList = file.listFiles();
        //tempList.length获取文件夹下所包含的文件或者文件夹的个数
        if (tempList.length > 0) {
            for (File f : tempList) {
                //如果是文件，读取文件内容并且复制
                if (f.isFile()) {
                    FileReader reader = new FileReader(f);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        mWriter.append(line);
                        mWriter.append("\r\n");
                        mWriter.flush();
                    }
                }
                if (f.isDirectory()) {
                    System.out.println(f.getName());
                    readFile(path + "/" + f.getName());
                }
            }
        }
    }
}