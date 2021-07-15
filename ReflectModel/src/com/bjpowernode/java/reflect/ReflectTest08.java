package com.bjpowernode.java.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @description: 反射UserService中的Method方法
 * @author: Damon
 * @date 2021/7/15 15:52
 */
public class ReflectTest08 {
    public static void main(String[] args) throws Exception {
        //获取类
        Class userServiceClass = Class.forName("com.bjpowernode.java.reflect.service.UserService");

        //获取所有的Method
        Method[] methods = userServiceClass.getDeclaredMethods();

        //遍历
        for (Method method : methods) {
            //修饰符列表
            System.out.println(Modifier.toString(method.getModifiers()));
            //方法的返回值类型
            Class type = method.getReturnType();
            String trueType = type.getSimpleName();
            System.out.println(trueType);
            //获取方法名
            System.out.println(method.getName());
            //方法的参数列表
            Class[] parameterTypes = method.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.println(parameterType.getSimpleName());
            }
        }

    }
}
