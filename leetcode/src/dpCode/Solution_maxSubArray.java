package dpCode;

public class Solution_maxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        int count = 1;
        while(count < nums.length){
            if (nums[count] + dp[count - 1] > nums[count]){
                dp[count] = dp[count - 1] + nums[count];
            }else {
                dp[count] = nums[count];
            }
            if (dp[count] > max) max = dp[count];
            count++;
        }
        return max;
    }
}
