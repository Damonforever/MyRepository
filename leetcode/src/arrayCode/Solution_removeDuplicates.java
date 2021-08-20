package arrayCode;

/**
 * @description: 删除有序数组中的重复项
 * @author: Damon
 * @date 2021/8/20 10:14
 */
public class Solution_removeDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int len = new Solution_removeDuplicates().removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int slow = 0, fast = 1;
        while (fast < len){
            if (nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
