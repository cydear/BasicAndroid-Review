package com.basic.android.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-10-30 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class ClassLoaderTest {
    private static String PATH = "/Users/oumind/Documents/AndroidWorkSpace/AndroidStudio/android-api-demo/BasicAndroid-Review/app/src/main/java/com/basic/android/classloader/";

    public static void main(String[] args) {
        DiskClassLoader diskClassLoader = new DiskClassLoader(PATH);

        try {
            Class clazz = diskClassLoader.findClass("com.basic.android.classloader.Student");
            System.out.println(clazz);
            if (clazz != null) {
                Object obj = clazz.newInstance();
                System.out.println(obj.getClass().getClassLoader());
                Method method= clazz.getDeclaredMethod("display");
                method.invoke(obj,null);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
