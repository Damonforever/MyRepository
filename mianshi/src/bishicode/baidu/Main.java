package bishicode.baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/7 19:28
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                nums[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        int[][] results = new int[n * k][n * k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int a = 0; a < k; a++) {
                    for (int b = 0; b < k; b++) {
                        results[i * k + a][j * k + b] = nums[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < n * k; i++) {
            for (int j = 0; j < n * k; j++) {
                System.out.print(results[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
