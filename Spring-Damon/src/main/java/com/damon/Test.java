package com.damon;

import com.damon.service.UseService;
import com.damon.service.UserService;
import com.spring.DamonApplicationContext;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/3 15:25
 */
public class Test {
    public static void main(String[] args) {
        DamonApplicationContext applicationContext = new DamonApplicationContext(AppConfig.class);

        UserService userService = (UserService) applicationContext.getBean("userService");//map<beanName,bean对象>
        userService.test();
    }
}
