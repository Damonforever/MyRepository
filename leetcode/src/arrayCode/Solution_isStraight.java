package arrayCode;

import java.util.Arrays;

public class Solution_isStraight {

    public static void main(String[] args) {
        int[] nums = {0,0,0,11,9};
        System.out.println(isStraight(nums));
    }
    static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int t =0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                t++;
            }
        }
        if(t >= 3 ){
            if(t == 3){
                if(nums[4] - nums[3] - 1 <= t){
                    return true;
                }else {
                    return false;
                }
            }else {
                return true;
            }
        }else{
            int count = t;
            for (int i = nums.length-1; i > t ; i--) {
                if(nums[i] - nums[i-1] == 1){

                }else {
                    if((nums[i] - nums[i-1] == 0 && nums[i] != 0) || nums[i] - nums[i-1] > t + 1){
                        return false;
                    }else {
                        if(nums[i] -nums[i-1] - 1 <= count){
                            count -= (nums[i] -nums[i-1] - 1);
                        }else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
