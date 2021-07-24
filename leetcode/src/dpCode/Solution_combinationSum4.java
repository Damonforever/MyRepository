package dpCode;

/**
 * @description: 组合总和 Ⅳ
 * @author: Damon
 * @date 2021/7/24 20:07
 */
public class Solution_combinationSum4 {
    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1,2,3},4));
    }
    public static int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) dp[i] += dp[i - num];
            }

        }
        return dp[target];
    }
}
