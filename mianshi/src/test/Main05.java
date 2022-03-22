package test;

import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/30 19:13
 */
public class Main05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int r = sc.nextInt();
        sc.close();
        int[][] nums = new int[n][n];
        int count = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = count++;
            }
        }

    }
}
