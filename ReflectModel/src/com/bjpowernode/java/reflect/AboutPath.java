package com.bjpowernode.java.reflect;

import java.io.FileReader;

/**
 * @description: idea 下文件路径问题
 * @author: Damon
 * @date 2021/7/14 20:13
 */
public class AboutPath {

    public static void main(String[] args) throws Exception {
        //这种方式的路径缺点是：移植性差，在IDEA中默认的当前路径是project的根
        //这个代码不在idea中打开，此路径就无效了
//        FileReader reader = new FileReader("ReflectModel/classinfo.properties");

        //可移植的通用路径
        //使用这个路径的前提是：这个文件必须在类路径下
        //类路径：凡是在src下的都是类路径
        /**
         * getContextClassLoader() 获取当前线程的类加载器对象
         * etResource() 当前线程对的类加载器默认从类的根路径下加载资源
         *
         * */
        String path = Thread.currentThread().getContextClassLoader()
                .getResource("classinfo2.properties").getPath();
        //获取到绝对路径
        // /F:/JavaWorkSpace/out/production/ReflectModel/classinfo2.properties
        System.out.println(path);
        String path2 = Thread.currentThread().getContextClassLoader()
                .getResource("com/bjpowernode/java/reflect/User.class").getPath();
        System.out.println(path2);
    }
}
