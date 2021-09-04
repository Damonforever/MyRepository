package com.damon.service;

import com.spring.*;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/3 15:37
 */
//不使用Scope注解表示为单例bean，使用@Scope("prototype")表示为原型bean
@Component("userService")
//@Scope("prototype")
public class UserServiceImpl implements BeanNameAware, InitializingBean, UserService {
    @Autowired
    private OrderService orderService;

    private String beanName;

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //验证某些属性是否为空
        System.out.println("初始化");
    }

    public void test(){
        System.out.println(orderService);
        System.out.println(beanName);
    }
}
