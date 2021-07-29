package arrayCode;

import java.util.HashMap;
import java.util.Map;

public class Solution_majorityElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(nums));
    }
    static int majorityElement(int[] nums) {
        int temp = nums[0];
        nums[0] = 1;
        //摩根投票法
        for (int i = 1; i < nums.length; i++) {
            if (nums[0] > 0){
                if (temp == nums[i]) {
                    nums[0]++;
                } else {
                    nums[0]--;
                }
            }else {
                temp = nums[i];
                nums[0]++;
            }
        }
        return temp;
    }
}
