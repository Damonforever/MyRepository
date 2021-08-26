package dpCode;

public class Solution_maxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9},2));
    }
    //多次买卖，包含手续费
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int sell = 0, buy = -prices[0];
        for (int i = 1; i < n; ++i) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }

    //多次买卖，包含冷冻期
//    public static int maxProfit(int[] prices) {
//        if (prices.length == 0) {
//            return 0;
//        }
//
//        int n = prices.length;
//        // f[i][0]: 手上持有股票的最大收益
//        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
//        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
//        int[][] f = new int[n][3];
//        f[0][0] = -prices[0];
//        for (int i = 1; i < n; ++i) {
//            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
//            f[i][1] = f[i - 1][0] + prices[i];
//            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
//        }
//        return Math.max(f[n - 1][1], f[n - 1][2]);
//    }

    //多次买卖不含冷冻期
//    public static int maxProfit(int[] prices) {
//        int len = prices.length;
//        int temp = 0;
//        int sum = 0;
//        int min = prices[0];
//        if (len >= 2){
//            for (int i = 1; i < len; i++) {
//                if(prices[i] < prices[i - 1]){
//                    min = prices[i];
//                    sum += temp;
//                    temp = 0;
//                }else {
//                    temp = Math.max(temp,prices[i] - min);
//                    min = Math.min(min,prices[i]);
//                }
//            }
//            sum += temp;
//        }
//        return sum;
//    }

    //单次买卖
//    public static int maxProfit1(int[] prices) {
//        int m = prices.length;
//        int temp = 0;
//        int min = prices[0];
//        if (m >= 2) {
//            for (int i = 1; i < m; i++) {
//                temp = Math.max(temp, prices[i] - min);
//                min = Math.min(min, prices[i]);
//            }
//        }
//        return temp;
//    }
//    //暴力解法
////    if(m >= 2){
////        for (int j = 0; j < m; j++) {
////            for (int i = 0; i <= j; i++) {
////                if(i != j){
////                    temp = Math.max(temp,prices[j]-prices[i]);
////                }
////            }
////        }
////    }
//        return temp;
//    }
}
