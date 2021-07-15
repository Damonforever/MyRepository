package com.bjpowernode.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * @description: 反射构造方法
 * @author: Damon
 * @date 2021/7/15 20:57
 */
public class ReflectTest11 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        Class vipClass = Class.forName("com.bjpowernode.java.reflect.bean.Vip");
        sb.append(Modifier.toString(vipClass.getModifiers())).append(" class ").append(vipClass.getSimpleName()).append(" {\n");
        Constructor[] vipConstructors = vipClass.getDeclaredConstructors();
        for (Constructor vipConstructor : vipConstructors) {
            sb.append("\t");
            sb.append(Modifier.toString(vipConstructor.getModifiers()));
            sb.append(" ");
            sb.append(vipClass.getSimpleName());
            sb.append("(");
            Class[] types = vipConstructor.getParameterTypes();
            for (Class type : types) {
                sb.append(type.getSimpleName());
                sb.append(",");
            }
            if (sb.charAt(sb.length() - 1) == ',') sb.deleteCharAt(sb.length() - 1);
            sb.append("){}\n");
        }
        sb.append("}");
        System.out.println(sb);
    }
}
