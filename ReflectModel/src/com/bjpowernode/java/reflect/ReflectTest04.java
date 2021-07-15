package com.bjpowernode.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/15 9:29
 */
public class ReflectTest04 {
    public static void main(String[] args) throws Exception {
        //获取类
        Class studentClass = Class.forName("com.bjpowernode.java.reflect.bean.Student");
        //获取类中所有public属性
        Field[] fields = studentClass.getFields();
        System.out.println(fields.length);
        Field field = fields[0];
        //.getName 是获取属性的名字
        System.out.println(field.getName());
        //获取属性的类型,先通过getType拿到Class，再通过getName获取属性的类型
        //使用getSimpleName可以获取简单名
        Class type = field.getType();
        String name = type.getName();
        String simpleName = type.getSimpleName();
        //获取属性的修饰符,返回的修饰符是数字，每个数字是修饰符的代号
        //可以将这个数字转换为字符串
        int modifiers = field.getModifiers();
        String s = Modifier.toString(modifiers);
        System.out.println();


        //获取所有属性
        Field[] declaredFields = studentClass.getDeclaredFields();

        System.out.println(declaredFields.length);
    }
}
