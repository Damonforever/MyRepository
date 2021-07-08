package dpCode;

/**
 * @description: 环形子数组的最大和
 * @author: Damon
 * @date 2021/7/8 21:59
 */
public class Solution_maxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax,max,curMin,min,sum;
        curMax = curMin = max = min = sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            curMax = curMax > 0 ? curMax + nums[i] : nums[i];
            max = Math.max(curMax, max);
            curMin = curMin < 0 ? curMin + nums[i] : nums[i];
            min = Math.min(curMin, min);
        }
        if (max < 0) return max;
        return Math.max(sum - min, max);
    }
}
