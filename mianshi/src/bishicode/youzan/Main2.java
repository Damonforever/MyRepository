package bishicode.youzan;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/21 10:37
 */
public class Main2 {
    public boolean isMonotonic (int[] nums) {
        int len = nums.length;
        boolean incrFlag = false;
        boolean decFlag = false;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) incrFlag = true;
            if (nums[i] < nums[i - 1]) decFlag = true;
        }
        return !incrFlag || !decFlag;
    }
    public boolean isMonotonic1 (int[] nums) {
        int len = nums.length;
        if (len <= 1) return true;
        if (nums[0] == nums[1]) return false;
        boolean flag = nums[1] > nums[0];
        if (flag){
            for (int i = 2; i < len; i++) {
                if (nums[i] - nums[i - 1] <= 0) return false;
            }
        }else {
            for (int i = 2; i < len; i++) {
                if (nums[i] - nums[i-1] >= 0) return false;
            }
        }
        return true;
    }
}
