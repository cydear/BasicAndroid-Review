package com.basic.android.io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-10-31 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class ByteStreamTest {
    private static String PATH = "/Users/oumind/Documents/AndroidWorkSpace/AndroidStudio/android-api-demo/BasicAndroid-Review/app/src/main/java/com/basic/android/io/";
    private static String READ_FILE = "hello.txt";
    private static String RESULT_FILE = "result.txt";

    public static void main(String[] args) {
        //fileInputStreamTest();
        //dataInputStreamTest();
        //objectOutStreamTest();
        objectInputStreamTest();
    }

    /**
     * FileInputStream和FileInputStream
     */
    private static void fileInputStreamTest() {
        try {
            //将文件读入内存
            FileInputStream fis = new FileInputStream(new File(PATH, READ_FILE));
            //将数据从内存中读出至文件
            FileOutputStream fos = new FileOutputStream(new File(PATH, RESULT_FILE));

            //每次传输1kb
            byte[] bytes = new byte[1024];
            //实际读取的字节数
            int temp = 0;
            while ((temp = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, temp);
            }
            //刷新 将数据刷新至内存
            fos.flush();
            fis.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * DataInputStream和DataInputStream
     * 数据字节输出流可以将内存中的int i=10 写入到硬盘文件中，写进去的不是字符串，而是二进制数据（带类型）
     * <p>
     * 要使用数据字节输入流读入数据，必须提前知道文件的存储格式和顺序，读的顺序必须和写入的顺序相同
     */
    private static void dataInputStreamTest() {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(PATH, RESULT_FILE)));
            byte b = 10;
            int i = 11;
            dos.writeByte(b);
            dos.writeInt(i);
            dos.flush();
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ObjectOutputStream 序列化内存中对象到硬盘
     * ObjectInputStream 将硬盘中的数据反序列化到JVM内存
     */
    public static void objectOutStreamTest() {
        try {
            ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream(new File(PATH, RESULT_FILE)));
            UserObject user = new UserObject();
            user.setUserName("tom");
            user.setNickName("tom best");
            user.setAge(20);
            dos.writeObject(user);
            dos.flush();
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void objectInputStreamTest() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(PATH, RESULT_FILE)));
            Object obj = ois.readObject();
            if (obj instanceof UserObject) {
                UserObject userObject = (UserObject) obj;
                System.out.println(userObject.toString());
            }
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
