package com.bjpowernode.java.reflect;

/**
 * @description: 可变长参数
 * @author: Damon
 * @date 2021/7/15 15:20
 */
public class ArgsTest {
    public static void main(String[] args) {
//        m();
//        m(10);
//        m(10,20);
        m2(2);
        m2(2,5,8);
    }
    public static void m(int... args){
        System.out.println("m方法执行了");
    }
    public static void m2(int a, int... args){
        System.out.println("m2方法执行了");
    }
}
