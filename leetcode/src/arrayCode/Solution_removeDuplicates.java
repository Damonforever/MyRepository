package arrayCode;

/**
 * @description: 删除有序数组中的重复项
 * @author: Damon
 * @date 2021/8/20 10:14
 */
public class Solution_removeDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1};
        int len = new Solution_removeDuplicates().reduce(nums);
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
    public int reduce(int[] nums){
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return 1;
        int count = 0;
        int sum = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i-1]){
                int k = i;
                while (i < len - sum && nums[i] == nums[i-1]){
                    count++;
                    i++;
                }
                sum += count;
                while (k+count < len){
                 nums[k] = nums[k + count];
                 k++;
                }
                i = i-count;
                count = 0;
            }
            if (i + sum >= len - 1) break;
        }
        return len - sum;
    }
}
