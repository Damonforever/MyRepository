package dpCode;

/**
 * @description: 跳跃游戏 II
 * @author: Damon
 * @date 2021/7/28 10:15
 */
public class Solution_jump {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,0,1,4}));
    }
    public static int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            int max = -1;
            int index = i + 1;
            for (int j = i + 1; j <= nums[i] + i; j++){
                if (max < j + nums[j] ){
                    max = j + nums[j];
                    index = j;
                }
                if (dp[j] == 0) dp[j] = dp[i] + 1;
                if (dp[len - 1] != 0) break;
            }
            if (dp[len - 1] != 0) break;
            i = index - 1;
        }
        return dp[len - 1];
    }
}
