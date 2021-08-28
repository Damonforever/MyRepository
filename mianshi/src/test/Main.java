package test;

import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/27 20:31
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strings = sc.nextLine().split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += (i+1);
            if (sum < count){
                System.out.println(i + 1);
                return;
            }
        }
        int len = nums.length + 1;
        while(sum > count){
            count += len;
            len++;
        }
        System.out.println(len);
    }

}
