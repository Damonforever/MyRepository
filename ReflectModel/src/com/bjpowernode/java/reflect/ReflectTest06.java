package com.bjpowernode.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @description: 通过反射机制，反编译一个类的属性Field
 * @author: Damon
 * @date 2021/7/15 9:52
 */
public class ReflectTest06 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        Class aClass = Class.forName("com.bjpowernode.java.reflect.bean.Student");
        sb.append(Modifier.toString(aClass.getModifiers()) +" class " + aClass.getSimpleName() + " {");
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            sb.append("\n");
            sb.append("\t");
            sb.append(Modifier.toString(field.getModifiers()));
            sb.append(" ");
            sb.append(field.getType().getSimpleName());
            sb.append(" ");
            sb.append(field.getName()).append(";");
        }
        sb.append("\n");
        sb.append("}");
        System.out.println(sb.toString());
    }
}
