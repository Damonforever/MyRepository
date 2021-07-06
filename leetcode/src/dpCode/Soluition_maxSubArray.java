package dpCode;

public class Soluition_maxSubArray {
    public int maxSubArray(int[] nums) {
//        int n = nums.length;
//        if(n == 0){
//            return 0;
//        }
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        for (int i = 1; i < n; i++) {
//            dp[i] = Math.max(nums[i],nums[i] + dp[i-1]);
//        }
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            res = Math.max(res,dp[i]);
//        }
//        return res;
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int num1 = nums[0];
        int num2 = 0;
        int res = num1;
        for (int i = 1; i < n; i++) {
            num2 = Math.max(nums[i],nums[i] + num1);
            num1 = num2;
            res = Math.max(res,num2);
        }
        return res;
    }
}
