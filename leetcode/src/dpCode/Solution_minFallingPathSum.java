package dpCode;

/**
 * @description: 下降路径最小和
 * @author: Damon
 * @date 2021/7/16 15:38
 */
public class Solution_minFallingPathSum {
    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));
    }
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) dp[i][j] = matrix[i][j];
                else {
                    if (j == 0) dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j],dp[i - 1][j + 1]);
                    else if (j == n - 1) dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j],dp[i - 1][j - 1]);
                    else dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j],Math.min(dp[i - 1][j + 1],dp[i - 1][j - 1]));
                    if (i == n - 1) dp[i][0] = Math.min(dp[i][0],dp[i][j]);
                }
            }
        }
        return dp[n-1][0];
    }
}
