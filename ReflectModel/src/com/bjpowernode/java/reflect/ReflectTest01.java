package com.bjpowernode.java.reflect;

/**
 * Created by Damon on 2021/7/9.
 */
public class ReflectTest01 {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("com.bjpowernode.java.reflect.User");
            Object o = null;
            try {
                o = c.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
