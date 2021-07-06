package dpCode;

import java.util.HashMap;

public class Solution_coinChange {
    //备忘录法则
//    public int coinChange(int[] coins, int amount) {
//        HashMap<Integer,Integer> memo = new HashMap<>();
//        return dp(memo,amount,coins);
//    }
//    public int dp(HashMap<Integer,Integer> memo,int num,int[] coins){
//        if (memo.get(num) != null){
//            return memo.get(num);
//        }
//        if(num == 0){
//            return 0;
//        }
//        if (num < 0){
//            return -1;
//        }
//        int res = num;
//        for (int i = 0; i < coins.length; i++) {
//            int subproblem = dp(memo,num-coins[i],coins);
//            if(subproblem == -1){
//                continue;
//            }
//            res = Math.min(res,1+subproblem);
//        }
//        if(res != num){
//            memo.put(num,res);
//        }else {
//            memo.put(num,-1);
//        }
//        return memo.get(num);
//    }

    //dp数组迭代
    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount+1;
        }
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins){
                if(i - coin < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 :dp[amount];
    }

}
