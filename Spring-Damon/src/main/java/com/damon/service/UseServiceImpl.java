package com.damon.service;

import com.spring.Autowired;
import com.spring.BeanNameAware;
import com.spring.Component;
import com.spring.InitializingBean;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/3 15:37
 */
//不使用Scope注解表示为单例bean，使用@Scope("prototype")表示为原型bean
@Component("useService")
//@Scope("prototype")
public class UseServiceImpl implements InitializingBean {
    @Autowired
    private OrderService orderService;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //验证某些属性是否为空
        System.out.println("初始化");
    }

    public void test(){
        System.out.println(orderService);
        System.out.println(name);
    }
}
