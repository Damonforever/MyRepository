package com.spring;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/3 22:33
 */
public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
