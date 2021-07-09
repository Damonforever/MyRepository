package dpCode;

/**
 * @description: 乘积最大子数组，墙裂推荐最大最小值交换
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
    //交换最大和最小值的方法就很妙啊
    public int maxProduct2(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1; //一个保存最大的，一个保存最小的。
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){ int tmp = imax; imax = imin; imin = tmp;} //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
}
