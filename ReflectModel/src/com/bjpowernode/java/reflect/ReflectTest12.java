package com.bjpowernode.java.reflect;

import java.lang.reflect.Constructor;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/15 21:18
 */
public class ReflectTest12 {
    public static void main(String[] args) throws Exception {
        Class vipClass = Class.forName("com.bjpowernode.java.reflect.bean.Vip");
        //调用无参构造方法
        Object obj = vipClass.newInstance();
        //调有参构造方法
        Constructor one = vipClass.getDeclaredConstructor(int.class);
        Object oneObj = one.newInstance(1);
        System.out.println(oneObj);
    }
}
