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

//        Thread thread = new Thread(() -> {
//            System.out.println("hello");
//        });
//        thread.start();
//        thread.start();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }
        List<Integer> subList = list.subList(1,3);
        list.add(5);
        subList.forEach(System.out::println);
        subList.add(6);
        subList.remove(0);
    }
}
