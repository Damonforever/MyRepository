package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/15 19:07
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String[] strings1 = input[0].split(",");
        if (input.length <= 1){
            System.out.println(Integer.parseInt(strings1[3]));
        }else {
            String[] strings2 = input[1].split(",");
            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < 4; i++) {
                if(count1 < strings1.length && count2 < strings2.length){
                    if (Integer.parseInt(strings1[count1]) > Integer.parseInt(strings2[count2])){
                        if (i == 3) {
                            System.out.println(Integer.parseInt(strings1[count1]));
                            return;
                        }
                        count1++;
                    }else{
                        if (i == 3) {
                            System.out.println(Integer.parseInt(strings2[count2]));
                            return;
                        }
                        count2++;
                    }
                }else {
                    if (count1 >= strings1.length - 1){
                        if (i == 3) {
                            System.out.println(Integer.parseInt(strings2[count2]));
                            return;
                        }
                        count2++;
                    }
                    if (count2 >= strings2.length - 1){
                        if (i == 3) {
                            System.out.println(Integer.parseInt(strings1[count1]));
                            return;
                        }
                        count1++;
                    }
                }
            }
        }
    }
}
