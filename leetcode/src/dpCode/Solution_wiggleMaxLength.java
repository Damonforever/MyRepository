package dpCode;

/**
 * @description: 摆动序列
 * @author: Damon
 * @date 2021/7/21 15:27
 */
public class Solution_wiggleMaxLength {
    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{3,3,3,2,5}));
    }
    public static int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
