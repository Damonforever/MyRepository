package dpCode;

/**
 * @description: 整数的拆分
 * @author: Damon
 * @date 2021/7/24 20:47
 */
public class Solution_integerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(12));
    }
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max,Math.max(j * (i - j),j * dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
