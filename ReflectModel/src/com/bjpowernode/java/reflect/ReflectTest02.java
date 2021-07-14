package com.bjpowernode.java.reflect;

import java.io.FileReader;
import java.util.Properties;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/14 19:55
 */
public class ReflectTest02 {
    public static void main(String[] args) throws Exception{
        //通过IO流读取classinfo.properties文件
        FileReader reader = new FileReader("ReflectModel/classinfo.properties");
        // 创建属性类对象
        Properties pro = new Properties();//key value 都是String
        //加载
        pro.load(reader);
        //关闭流
        reader.close();
        //通过key获取value
        String className = pro.getProperty("className");
//        System.out.println(className);

    }
}
