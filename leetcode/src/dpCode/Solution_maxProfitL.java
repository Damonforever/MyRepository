package dpCode;

/**
 * @description: labuladong模板
 * @author: Damon
 * @date 2021/8/23 10:23
 */
public class Solution_maxProfitL {
    public static void main(String[] args) {
        System.out.println(new Solution_maxProfitL().maxProfit(1,new int[]{1,2}));
    }
    //一次买卖
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, -price);
        }
        return dp_i_0;
    }
    //多次买卖
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, temp - price);
        }
        return dp_i_0;
    }
    //多次买卖加冷冻期
    public int maxProfit2(int[] prices) {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;
        for (int price : prices) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - price);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }
    //多次买卖加手续费
    public int maxProfit(int[] prices, int fee) {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, temp - price - fee);
        }
        return dp_i_0;
    }
    //最多完成k笔交易
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k > n/2) return maxProfit1(prices);
        int[][][] dp = new int[n][k+1][2];
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--){
                if (i == 0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = Integer.MIN_VALUE;
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
            }
        }
        return dp[n-1][k][0];
    }
}
