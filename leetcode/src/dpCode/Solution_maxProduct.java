package dpCode;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/9 14:55
 */
public class Solution_maxProduct {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4,-1}));
    }
    public static int maxProduct(int[] nums) {
        if (nums.length < 1) return 0;
        int max = nums[0];
        int min = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] * nums[i] >= 0){
                dp[i] = Math.max(dp[i - 1] * nums[i], nums[i]);
                dp[i] = Math.max(dp[i],min * nums[i]);
                min = nums[i] == 0 ? Math.min(nums[i],nums[i - 1] *nums[i]) : Math.min(Math.min(nums[i],min * nums[i]),nums[i - 1] * nums[i]);
                max = Math.max(max,dp[i]);
            }
            if (dp[i - 1] * nums[i] < 0) {
                max = Math.max(max,Math.max(nums[i],min * nums[i]));
                dp[i] = Math.max(Math.max(dp[i - 1] * nums[i],min*nums[i]), Math.max(nums[i],nums[i-1]*nums[i]));
                min = Math.min(dp[i - 1] * nums[i],min * nums[i]);

            }
        }
        return max;
    }
}
