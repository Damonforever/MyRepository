package dpCode;


/**
 * @description: 完全平方数
 * @author: Damon
 * @date 2021/7/24 21:37
 */
public class Solution_numSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++){
                min = Math.min(min,dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
