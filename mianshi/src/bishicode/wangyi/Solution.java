package bishicode.wangyi;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/21 15:05
 */
public class Solution {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1,0,1,1,0},{0,1,0,1,0},{1,1,0,0,1},{0,0,0,0,1}};
        System.out.println(minSailCost1(input));
    }
    public static int minSailCost (int[][] input) {
        // write code here
        int m = input.length;
        int n = input[0].length;
        int[][] dp = new int[m][n];
        if (input[0][0] == 2) return -1;
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            if (input[0][i] == 2) break;
            else if (input[0][i] == 1){
                dp[0][i] = dp[0][i-1] + 1;
            }else {
                dp[0][i] = dp[0][i-1] + 2;
            }
        }
        for (int i = 1; i < m; i++) {
            if (input[i][0] == 2) break;
            else if (input[i][0] == 1){
                dp[i][0] = dp[i - 1][0] + 1;
            }else {
                dp[i][0] = dp[i - 1][0] + 2;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (input[i][j] == 2){
                    continue;
                }
                if (dp[i - 1][j] != 0  && dp[i][j - 1] != 0){
                    if (dp[i - 1][j] < dp[i][j - 1]){
                        if (input[i][j] == 0){
                            dp[i][j] = dp[i - 1][j] + 2;
                        }else {
                            dp[i][j] = dp[i - 1][j] + 1;
                        }
                    }else {
                        if (input[i][j] == 0){
                            dp[i][j] = dp[i][j - 1] + 2;
                        }else {
                            dp[i][j] = dp[i][j - 1] + 1;
                        }
                    }
                }else{
                    if (dp[i - 1][j] != 0){
                        if (input[i][j] == 0){
                            dp[i][j] = dp[i - 1][j] + 2;
                        }else {
                            dp[i][j] = dp[i - 1][j] + 1;
                        }
                    }
                    if (dp[i][j - 1] != 0){
                        if (input[i][j] == 0){
                            dp[i][j] = dp[i][j - 1] + 2;
                        }else {
                            dp[i][j] = dp[i][j - 1] + 1;
                        }
                    }
                }

            }
        }
        return dp[m-1][n-1] == 0 ? -1 :dp[m-1][n-1];
    }

    public static int minSailCost1 (int[][] input) {
        // write code here
        int m = input.length;
        int n = input[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            if (input[0][i] == 1){
                dp[0][i] = dp[0][i-1] + 1;
            }else {
                dp[0][i] = dp[0][i-1] + 2;
            }
        }
        for (int i = 1; i < m; i++) {
            if (input[i][0] == 1){
                dp[i][0] = dp[i - 1][0] + 1;
            }else {
                dp[i][0] = dp[i - 1][0] + 2;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int tmp = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                if (input[i][j] == 1){
                    dp[i][j] = tmp + 1;
                }else {
                    dp[i][j] = tmp + 2;
                }
                if (j < n - 1 && dp[i-1][j+ 1] != 0){
                    dp[i-1][j+ 1] = Math.min(dp[i-1][j+ 1],dp[i][j] + input[i -1][j + 1]);
                }
                if (i < m -1 && dp[i+ 1][j-1] != 0){
                    dp[i+ 1][j-1] = Math.min(dp[i+ 1][j-1],dp[i][j] + input[i + 1][j - 1]);
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int tmp = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                if (input[i][j] == 1){
                    dp[i][j] = Math.min(tmp + 1,dp[i][j]);
                }else {
                    dp[i][j] = Math.min(tmp + 2,dp[i][j]);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
