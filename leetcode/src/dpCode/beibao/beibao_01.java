package dpCode.beibao;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/19 15:41
 */
public class beibao_01 {
    public static void main(String[] args) {
        System.out.println(knaspack(4,3, new int[]{2,1,3}, new int[]{4,2,3}));
    }
    public static int knaspack(int w, int n, int[] wt, int[] val){
        int[][] dp = new int[n+1][w+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j - wt[i-1] < 0) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j - wt[i-1]] + val[i-1],dp[i-1][j]);
            }
        }
        return dp[n][w];
    }
}
