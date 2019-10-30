package com.basic.android.classloader;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-10-30 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class ClassLoaderAnalysis {
    public static void main(String[] args) {
        /**
         * ClassLoader分类：
         * 1. 系统类加载器:BootstrapClassLoader,ExtensionsClassLoader和AppClassLoader
         * 2. 自定义类加载器
         */

        //查看BootstrapClassLoader所在的目录
        //BootstrapClassLoader C++编写 主要用于加载Java虚拟机运行时所需要的系统类
        System.out.println(System.getProperty("sun.boot.class.path"));

        //Extensions ClassLoader 用于加载Java的拓展类
        System.out.println(System.getProperty("java.ext.dirs"));

        //App ClassLoader负责加载当前应用程序classpath目录下的所有jar和class文件

        //Custom ClassLoader自定义类加载器

        ClassLoader loader = ClassLoaderAnalysis.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent();
        }
    }
}
