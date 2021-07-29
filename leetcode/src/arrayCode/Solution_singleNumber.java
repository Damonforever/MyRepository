package arrayCode;

/**
 * @description: 只出现一次的数字
 * @author: Damon
 * @date 2021/7/29 10:01
 */
public class Solution_singleNumber {
    // 线性时间，不适用额外的空间
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
