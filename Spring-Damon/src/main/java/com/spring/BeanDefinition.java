package com.spring;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/3 16:47
 */
public class BeanDefinition {
    //类名和作用域
    private Class clazz;
    private String scope;

//    public BeanDefinition(Class clazz, String scope) {
//        this.clazz = clazz;
//        this.scope = scope;
//    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
