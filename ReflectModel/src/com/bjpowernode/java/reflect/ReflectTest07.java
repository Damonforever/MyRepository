package com.bjpowernode.java.reflect;

import java.lang.reflect.Field;

/**
 * @description: 通过反射机制访问一个java对象的属性
 * @author: Damon
 * @date 2021/7/15 10:30
 */
public class ReflectTest07 {
    public static void main(String[] args) throws Exception {
        //获取类
        Class studentClass = Class.forName("com.bjpowernode.java.reflect.bean.Student");
        Object obj = studentClass.newInstance();//obj对象就是Student对象。（底层调用无参构造方法）
        //获取no属性
        Field noFiled = studentClass.getDeclaredField("no");
        //给no属性赋值
        noFiled.set(obj,2222);//给obj对象的no属性赋值2222
        //读取属性的值
        System.out.println(noFiled.get(obj));

        //访问私有的属性
        Field nameField = studentClass.getDeclaredField("name");
        //打破封装,才可以操作，但容易给不法分子留下机会
        nameField.setAccessible(true);
        nameField.set(obj,"jackson");
        System.out.println(nameField.get(obj));
    }
}
