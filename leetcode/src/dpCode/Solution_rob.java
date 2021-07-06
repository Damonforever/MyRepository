package dpCode;

/**
 * @description: 打家劫舍
 * @author: Damon
 * @date 2021/7/6 10:19
 */
public class Solution_rob {
    public static void main(String[] args) {//6,6,4,8,4,3,3,10
        System.out.println(rob(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}));
    }
    //首尾不相连
    public static int rob(int[] nums) {
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
    //首尾相连
//    public static int rob(int[] nums) {
//        if(nums.length < 2) return nums[0];
//        if (nums.length < 3) return Math.max(nums[0],nums[1]);
//        if (nums.length < 4) return Math.max(Math.max(nums[0],nums[1]),nums[2]);
//        //从0开始不包含尾
//        int dp1 = nums[0];
//        int dp2 = nums[1];
//        //从一开始包含尾
//        int dp3 = nums[1];
//        int dp4 = nums[2];
//        if (nums[0] > nums[1]) dp2 = nums[0];
//        if (nums[1] > nums[2]) dp4 = nums[1];
//        for (int i = 2; i < nums.length - 1; i++) {
//            int temp1 = dp2;
//            int temp2 = dp4;
//            if (nums[i] + dp1 > dp2) dp2 = nums[i] + dp1;
//            if (nums[i + 1] + dp3 > dp4) dp4 = nums[i + 1] + dp3;
//            dp1 = temp1;
//            dp3 = temp2;
//        }
//        dp1 = Math.max(dp1,dp2);
//        dp3 = Math.max(dp3,dp4);
//        return Math.max(dp1,dp3);
//    }
}
