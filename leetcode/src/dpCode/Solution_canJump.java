package dpCode;

import java.util.Arrays;

/**
 * @description: 跳跃游戏
 * @author: Damon
 * @date 2021/7/7 10:31
 */
public class Solution_canJump {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,0,1,4}));
    }

    //不计步数
//    public boolean canJump(int[] nums) {
//        int max = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (i <= max){
//                max = Math.max(max,i + nums[i]);
//                if (max >= nums.length - 1) return true;
//            }
//        }
//        return false;
//    }
    //统计步数
    public static int jump(int[] nums){
        int max = 0;
        int count = 1;
        boolean flag = false;
        int j = 0;
        int k = 0;
        int[] memory = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(nums.length - 1 == 0) return 0;
            if (i <= max && !flag){
                max = Math.max(max,i + nums[i]);
                memory[i] = i + nums[i];
                if (max >= nums.length - 1) flag = true;
            }else {
                j = i - 1;
                break;
            }
        }
        while (j > 0){
            while (memory[k] < j){
                k++;
            }
            j = k;
            k = 0;
            count++;
        }

        return count;
    }
}
