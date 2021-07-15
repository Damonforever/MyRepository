package com.bjpowernode.java.reflect.service;

/**
 * @description: 一个测试的用户业务类
 * @author: Damon
 * @date 2021/7/15 15:54
 */
public class UserService {

    int no;
    int age;

    /**
     *
     * @param name 用户名
     * @param password 密码
     * @return true表示成功，false表示失败
     */
    public boolean login(String name, String password){
        if ("admin".equals(name) && "123".equals(password)) return true;
        return false;
    }
    public void logout(){
        System.out.println("安全退出");
    }
}
