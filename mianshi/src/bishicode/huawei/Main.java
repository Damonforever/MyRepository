package bishicode.huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/8 19:03
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(",");
        int m = Integer.parseInt(strings[0]);
        int n = Integer.parseInt(strings[1]);
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        System.out.println(helper(nums));

    }
    public static int helper(int[][] nums){
        int MAX = 10000;
        int[][] dp = new int[nums.length][nums[0].length];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i],MAX);
        }
        dp[0][0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (i == 0 && j==0){
                    continue;
                }
                if (i == 0 && j!=0){
                    int numn = j-1;
                    while (numn >= 0){
                        if (numn + nums[i][numn] >= j){
                            dp[i][j] = Math.min(dp[i][j],dp[i][numn] + 1) ;
                        }
                        numn--;
                    }
                }
                if (i !=0 && j == 0){
                    int numn = i-1;
                    while (numn >= 0){
                        if (numn + nums[i][numn] >= j){
                            dp[i][j] = Math.min(dp[i][j],dp[numn][j] + 1) ;
                        }
                        numn--;
                    }
                }
                if (i != 0 && j!= 0){
                    int numn = j-1;
                    while (numn >= 0){
                        if (numn + nums[i][numn] >= j){
                            dp[i][j] = Math.min(dp[i][j],dp[i][numn] + 1) ;
                        }
                        numn--;
                    }
                    numn = i -1;
                    while (numn >= 0){
                        if (numn + nums[i][numn] >= j){
                            dp[i][j] = Math.min(dp[i][j],dp[numn][j] + 1) ;
                        }
                        numn--;
                    }
                }
            }
        }
        return dp[nums.length-1][nums[0].length - 1] == MAX ? -1 : dp[nums.length-1][nums[0].length - 1];
    }
}
