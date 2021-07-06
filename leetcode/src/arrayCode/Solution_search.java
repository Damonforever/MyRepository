package arrayCode;

public class Solution_search {
    public int search(int[] nums, int target) {
        int count = 0;
        if(nums.length==0 || target > nums[nums.length-1] || target < nums[0]){
            count = 0;
        }else {
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] <= target){
                    if(nums[i] == target){
                        count++;
                    }
                }else {
                    break;
                }
            }
        }
        return count;
    }
}
