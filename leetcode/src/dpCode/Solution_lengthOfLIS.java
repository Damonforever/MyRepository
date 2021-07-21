package dpCode;

import java.util.Arrays;

public class Solution_lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if(dp[i] > res){
                res = dp[i];
            }
        }
        return res;
    }
    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i],dp[j]+1);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0, k = i; j <= k; j++,k--) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i],dp[j]+1);
                if (nums[i] > nums[k]) dp[i] = Math.max(dp[i],dp[k]+1);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
