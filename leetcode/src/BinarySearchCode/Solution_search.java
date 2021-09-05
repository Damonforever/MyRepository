package BinarySearchCode;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/4 21:51
 */
public class Solution_search {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;
        int l = 0, r = n - 1;
        while (l <= r){
            int middle = l + (r - l)/2;
            if (nums[middle] == target){
                return middle;
            }
            if (nums[0] <= nums[middle]){
                if (nums[0] <= target && target < nums[middle]) r = middle - 1;
                else l = middle + 1;
            }else {
                if (nums[middle] < target && target <= nums[n-1]) l = middle + 1;
                else r = middle - 1;
            }
        }
        return -1;
    }
}
