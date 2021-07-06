package dpCode;

public class Solution_maxProfit {
    public int maxProfit(int[] prices) {
    int m = prices.length;
    int temp = 0;
    if(m >= 2){
        for (int j = 0; j < m; j++) {
            for (int i = 0; i <= j; i++) {
                if(i != j){
                    temp = Math.max(temp,prices[j]-prices[i]);
                }
            }
        }
    }
    return temp;
    }
}
