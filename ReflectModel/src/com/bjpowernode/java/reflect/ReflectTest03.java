package com.bjpowernode.java.reflect;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/14 20:06
 */
public class ReflectTest03 {
    public static void main(String[] args) {
        try {
            //此方法的执行会导致类加载
            Class.forName("com.bjpowernode.java.reflect.MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

