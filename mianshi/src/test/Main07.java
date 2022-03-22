package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2022/3/19 15:56
 */
public class Main07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.nextLine();
        int[][] tags = new int[m][2];
        int t,x;
        for (int i = 0; i < m; i++) {
            t = sc.nextInt();
            x = sc.nextInt();
            if (t == 0){
                help0(nums,x);
            }else {
                help1(nums,x);
            }
            sc.nextLine();
        }

    }
    static void help0(int[] nums,int x){
        //升序
        int[] temp = Arrays.copyOfRange(nums,0,x);
        Arrays.sort(temp);
        for (int i = 0; i < x; i++) {
            nums[i] = temp[i];
        }

    }
    static void help1(int[] nums,int x){
        //降序
    }

}
