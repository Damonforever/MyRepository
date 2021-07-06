package arrayCode;

public class Solution_twoSum {
    public static void main(String[] args) {
        int[] s  = {2,7,11,15};
        twoSum(s,9);
    }

    static int[] twoSum(int[] nums, int target) {
        int init = 0;
        int len = nums.length-1;
        int[] arr = new int[2];
        while(init<=len){
            if(init < len){
                if (nums[init] < target){
                    if(nums[len] >= target){
                        len--;
                    }else{
                        if(nums[init] + nums[len] > target){
                            len--;
                        }else {
                            if(nums[init] + nums[len] == target){
                                arr[0] = nums[init];
                                arr[1] = nums[len];
                                break;
                            }else{
                                init++;
                            }
                        }
                    }
                }
            }
        }
        return arr;
    }
}
