package BinarySearchCode;

/**
 * @description: 左边界搜索
 * @author: Damon
 * @date 2021/8/3 8:59
 */
public class leftBound {
    int findLeftBound(int[] nums, int target){
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;
        while (left < right){
            int middle = (left + right)/2;
            if (nums[middle] == target){
                right = middle;
            }else if (nums[middle] > target){
                right = middle;
            }else if (nums[middle] < target){
                left = middle + 1;
            }
        }
        if (left == nums.length) return -1;
        return nums[left] == target ? left : -1;
    }
}
