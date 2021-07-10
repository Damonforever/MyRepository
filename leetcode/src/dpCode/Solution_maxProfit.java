package dpCode;

public class Solution_maxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
    //多次买卖
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int temp = 0;
        int sum = 0;
        int min = prices[0];
        if (len >= 2){
            for (int i = 1; i < len; i++) {
                if(prices[i] < prices[i - 1]){
                    min = prices[i];
                    sum += temp;
                    temp = 0;
                }else {
                    temp = Math.max(temp,prices[i] - min);
                    min = Math.min(min,prices[i]);
                }
            }
            sum += temp;
        }
        return sum;
    }

    //单次买卖
//    public static int maxProfit(int[] prices) {
//        int m = prices.length;
//        int temp = 0;
//        int min = prices[0];
//        if (m >= 2) {
//            for (int i = 1; i < m; i++) {
//                temp = Math.max(temp, prices[i] - min);
//                min = Math.min(min, prices[i]);
//            }
//        }
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
