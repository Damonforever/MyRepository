package arrayCode;

import java.util.List;

public class Solution_maxSubArray {

    public int maxSubArray(int[] nums) {
        int storage = -101;
        int max = 0;
        int init = 0;
        int count = 0;
        int point = 0;
        while(point < nums.length){
            if(nums[point]<0){
                if(nums[point] > storage){
                    storage = nums[point];
                }
            }else{
                for(int i = point; i < nums.length-1; i++){
                    if(i+2 <= nums.length-1){
                        max += nums[i];
                        if(nums[i+1]+nums[i+2]>0){
                            max += (nums[i+1]+nums[i+2]);
                            i = i +2;
                        }else if (nums[i+1]>0){
                            max += nums[i+1];

                            i++;
                        }else {}
                    }
                }
            }
        }
        return storage;
    }
}
