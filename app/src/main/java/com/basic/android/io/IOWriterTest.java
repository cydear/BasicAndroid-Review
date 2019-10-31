package com.basic.android.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-10-31 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class IOWriterTest {
    private static String PATH = "/Users/oumind/Documents/AndroidWorkSpace/AndroidStudio/android-api-demo/BasicAndroid-Review/app/src/main/java/com/basic/android/io/";
    private static String READ_FILE = "hello.txt";
    private static String RESULT_FILE = "result.txt";

    public static void main(String[] args) {
        //fileReaderTest();
        //bufferedReaderTest();
        printStreamTest();
    }

    /**
     * FileReader和FileWriter
     */
    private static void fileReaderTest() {
        try {
            FileReader fr = new FileReader(new File(PATH, READ_FILE));
            FileWriter fw = new FileWriter(new File(PATH, RESULT_FILE));
            //每次读取1kb
            char[] chars = new char[512];
            //实际读取的字节数
            int temp = 0;
            while ((temp = fr.read(chars)) != -1) {
                fw.write(chars, 0, temp);
            }
            fw.flush();
            fr.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * BufferedReader和BufferedWriter
     */
    private static void bufferedReaderTest() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(PATH, READ_FILE))));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(PATH, RESULT_FILE))));
            String temp = null;
            while ((temp = br.readLine()) != null) {
                bw.write(temp);
                bw.newLine();
            }
            bw.flush();
            br.close();
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * PrintStream 是标准的输出流。默认打印到控制台
     */
    private static void printStreamTest() {
        String msg = "hello wrold";
        PrintStream ps = System.out;
        ps.println(msg);
    }
}
