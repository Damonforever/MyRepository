package dpCode;

/**
 * @description: 剪绳子1
 * @author: Damon
 * @date 2021/8/12 16:41
 */
public class Solution_cuttingRope {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 2; j < i; j++) {
                //第二次循环dp[i]要被更新多次，所以需要和之前的dp[i]相比较
                dp[i] = Math.max(dp[i],Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n + 1];
    }
    //尽可能分出来长度为3的段，数学证明不会
    public int cuttingRope1(int n) {
        if(n < 4){
            return n - 1;
        }
        int res = 1;
        while(n > 4){
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

}
