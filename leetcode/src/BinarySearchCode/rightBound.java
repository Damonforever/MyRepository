package BinarySearchCode;

/**
 * @description: 右边界搜索
 * @author: Damon
 * @date 2021/8/3 9:06
 */
public class rightBound {
    int findRightBound(int[] nums, int target){
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = (right+left)/2;
            if (nums[mid] == target){
                left = mid + 1;
            }else if (nums[mid] >target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        if (left == 0) return -1;
        return nums[left - 1] == target ? left - 1 : -1;
    }
}
