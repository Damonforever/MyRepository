package dpCode;

/**
 * @description: 最大正方形
 * @author: Damon
 * @date 2021/7/19 21:20
 */
public class Solution_maximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 1) dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 1) dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) continue;
                else {

                }
            }
        }
        return max;
    }
}
