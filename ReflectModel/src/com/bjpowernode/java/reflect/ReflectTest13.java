package com.bjpowernode.java.reflect;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/15 21:30
 */
public class ReflectTest13 {
    public static void main(String[] args) throws Exception {
        Class stringClass = Class.forName("java.lang.String");
        //获取String的父类
        Class superclass = stringClass.getSuperclass();
        System.out.println(superclass.getSimpleName());
        //获取String实现的所有接口
        Class[] interfaces = stringClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface.getSimpleName());
        }
    }
}
