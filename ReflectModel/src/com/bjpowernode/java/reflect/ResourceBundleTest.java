package com.bjpowernode.java.reflect;

import java.util.ResourceBundle;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/14 21:21
 */
public class ResourceBundleTest {
    public static void main(String[] args) {
        //资源绑定器只能绑定xxx.properties文件,并且这个文件必须在类路径下
        //并且在写路径的桑籍后，路径后面的扩展名不能写
        ResourceBundle bundle = ResourceBundle.getBundle("classinfo2");
        String className = bundle.getString("className");
        System.out.println(className);
    }
}
