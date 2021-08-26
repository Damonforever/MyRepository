package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/15 19:12
 */
public class Test02 {

    public static void main(String[] args) {
//        String s = "hello2";
//        final String s2 = "hello";
//        String s5 = "hello";
//        String s4 = s5+2;
//        String s3 = s2+2;
//        System.out.println(s==s3);
//        System.out.println(s==s4);
        System.out.println(my());
    }
    public static int my(){
        Integer num = 0;
        try {
            num = null;
            return num;
        }catch (Exception e){
            return 1;
        }finally {
            return 2;
        }
    }
}
