package prefixsum;

import java.util.HashMap;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/15 19:36
 */
public class Solution_subarraySum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1},2));
    }
    //前缀和暴力解法
    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] sums = new int[len + 1];
        sums[0] = 0;
        int count = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (sums[i] - sums[j] == k) count++;
            }
        }
        return count;
    }

    //加map优化
    public static int subarraySum1(int[] nums, int k) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        // base case
        sums.put(0,1);
        int ans = 0, temp_i = 0;
        for (int num : nums) {
            temp_i += num;
            int temp_j = temp_i - k;
            if (sums.containsKey(temp_j)) ans += sums.get(temp_j);
            sums.put(temp_i, sums.getOrDefault(temp_i, 0) + 1);
        }
        return ans;
    }
}
