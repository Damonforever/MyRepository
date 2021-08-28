package bishicode.kedaxunfei;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/28 19:41
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int score = Integer.parseInt(sc.nextLine());
        int[] ints = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        for (int i = 0; i < 25; i++) {
            int temp = ints[i];
            ints[i] = ints[ints.length - 1 - i];
            ints[ints.length - 1 - i] = temp;
        }
        int flag = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == score){
                flag = i + 1;
                break;
            }
        }
        if (flag >= 1 && flag <= 5){
            System.out.println("A+");
        }else if (flag >= 6 && flag<= 15){
            System.out.println("A0");
        }else if (flag >= 16 && flag <= 30){
            System.out.println("B+");
        }else if (flag >= 31 && flag <= 35){
            System.out.println("B0");
        }else if (flag >= 36 && flag <= 45){
            System.out.println("C+");
        }else if (flag >= 46 && flag <= 48){
            System.out.println("C0");
        }else {
            System.out.println("F");
        }
    }
}
