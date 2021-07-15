package com.bjpowernode.java.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @description: 反编译
 * @author: Damon
 * @date 2021/7/15 16:13
 */
public class ReflectTest09 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        //获取类
        Class userServiceClass = Class.forName("com.bjpowernode.java.reflect.service.UserService");
        sb.append(Modifier.toString(userServiceClass.getModifiers())).append(" class ").append(userServiceClass.getSimpleName()).append(" {\n");
        //获取所有的Method
        Method[] methods = userServiceClass.getDeclaredMethods();
        for (Method method : methods) {
            sb.append("\t");
            sb.append(Modifier.toString(method.getModifiers()));
            sb.append(" ");
            sb.append(method.getReturnType().getSimpleName());
            sb.append(" ");
            sb.append(method.getName());
            sb.append("(");
            //参数列表
            Class[] types = method.getParameterTypes();
            for (Class type : types) {
                sb.append(type.getSimpleName());
                sb.append(",");
            }
            if (sb.charAt(sb.length() - 1) == ',') sb.deleteCharAt(sb.length() - 1);

            sb.append("){}\n");
        }

        sb.append("}");
        System.out.println(sb.toString());
    }
}
