package dpCode.beibao;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/19 17:47
 */
public class Solution_helper {
    public static void main(String[] args) {
        System.out.println(helper1(4));
    }
    static int helper(int n,int[] choose){
        int len = 3;
        int[][] dp = new int[len + 1][n+1];
        for (int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - choose[i-1] >= 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-choose[i-1]];
                }else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[len][n];
    }
    static int helper1(int n){
        int[] dp = new int[n+ 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}
