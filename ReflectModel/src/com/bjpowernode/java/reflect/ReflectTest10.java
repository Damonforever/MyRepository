package com.bjpowernode.java.reflect;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/15 16:38
 */
public class ReflectTest10 {
    public static void main(String[] args) throws Exception{
        //获取类
        Class userServiceClass = Class.forName("com.bjpowernode.java.reflect.service.UserService");
        //创建对象
        Object obj = userServiceClass.newInstance();
        //获取Method
        Method loginMethod = userServiceClass.getDeclaredMethod("login", String.class, String.class);
        //调用方法四要素
        /*
        * loginMethod 方法
        * obj对象
        * 实参
        * 返回值
        * */
        Object retValue = loginMethod.invoke(obj, "admin", "123");
        System.out.println(retValue);

    }
}
