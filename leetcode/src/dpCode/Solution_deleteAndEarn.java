package dpCode;

/**
 * @description: 打家劫舍3.0，删除并获得点数
 * @author: Damon
 * @date 2021/7/6 16:19
 */
public class Solution_deleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int maxValue = 0;
        for (int i : nums){
            maxValue = Math.max(i,maxValue);
        }
        int[] numbers = new int[maxValue + 1];
        for (int i : nums){
            numbers[i] += i;
        }
        return rob(numbers);
    }
    private static int rob(int[] nums) {
        if (nums.length < 2) return nums[0];
        int dp1 = nums[0];
        int dp2 = nums[1];
        if (nums[0] > nums[1]) dp2 = nums[0];
        for (int i = 2; i < nums.length; i++) {
            int temp = dp2;
            if (nums[i] + dp1 > dp2) dp2 = nums[i] + dp1;
            dp1 = temp;
        }
        return Math.max(dp1,dp2);
    }
}
