package dpCode;

/**
 * @description: 等差数列划分
 * @author: Damon
 * @date 2021/7/13 16:25
 */
public class Solution_numberOfArithmeticSlices {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,8,9,10}));
    }
    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int len = nums.length;
        int sum = 0;
        int grade = nums[0] - nums[1];
        int count = 2;
        for (int i = 2; i < len; i++) {
            if (nums[i-1] - nums[i] == grade){
                count++;
            }else {
                if (count < 3){
                    grade = nums[i - 1] - nums[i];
                    count = 2;
                }else {
                    sum += ((1 + count - 2)*(count - 2)/2);
                    grade = nums[i - 1] - nums[i];
                    count = 2;
                }
            }
        }
        if (count >= 3) sum += ((1 + count - 2)*(count - 2)/2);
        return sum;
    }
}
