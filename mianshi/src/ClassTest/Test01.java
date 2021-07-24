package ClassTest;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/23 21:10
 */
public class Test01 {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setUserName("asd");
        user1.setPassword("123");
        user1.setSex("girl");
        User user2 = new User();
        
        user2.setUserName("asd");
        user2.setPassword("123");
        user2.setSex("girl");
        System.out.println(user1.equals(user2));


    }
}
