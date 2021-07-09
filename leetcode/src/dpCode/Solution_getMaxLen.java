package dpCode;

/**
 * @description: 乘积为正数的最长子数组长度
 * @author: Damon
 * @date 2021/7/9 16:39
 */
public class Solution_getMaxLen {
    public int getMaxLen(int[] nums) {
        int[] dpZ = new int[nums.length];
        int[] dpF = new int[nums.length];
        if(nums[0] > 0){
            dpZ[0] = 1;
        }else if (nums[0] < 0){
            dpF[0] = 1;
        }
        int max = dpZ[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == 0){
                dpF[i] = 0;
                dpZ[i] = 0;
            }else if (nums[i] > 0){
                dpZ[i] = dpZ[i-1] + 1;
                dpF[i] = dpF[i-1] > 0 ? dpF[i-1] + 1 : 0;
            }else {
                dpZ[i] = dpF[i-1] > 0 ? dpF[i-1] + 1 : 0;
                dpF[i] = dpZ[i-1] + 1;
            }
            max = Math.max(max,dpZ[i]);
        }
        return max;
    }
}
