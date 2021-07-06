package dpCode;

public class Solution_maxValue {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int t = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            t += grid[i][0];
            dp[i][0] = t;
        }
        t = 0;
        for (int i = 0; i < n; i++) {
            t += grid[0][i];
            dp[0][i] = t;
        }
        if(m > 1 && n > 1){
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                   dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
