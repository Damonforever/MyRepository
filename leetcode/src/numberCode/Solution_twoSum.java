package numberCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数之和
 * @author: Damon
 * @date 2021/7/12 19:57
 */
public class Solution_twoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other) && map.get(other) != i) return new int[]{i,map.get(other)};
        }
        return new int[]{-1,-1};
    }
}
