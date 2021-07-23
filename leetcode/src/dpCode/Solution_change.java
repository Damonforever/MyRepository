package dpCode;

/**
 * @description: 零钱兑换2
 * @author: Damon
 * @date 2021/7/23 19:58
 */
public class Solution_change {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
