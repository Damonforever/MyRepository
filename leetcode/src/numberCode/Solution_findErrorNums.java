package numberCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 错误的集合
 * @date 2021/7/4 15:55
 */
public class Solution_findErrorNums {

    public int[] findErrorNums(int[] nums) {
        int sum = (1 + nums.length) * nums.length / 2;
        Set<Integer> set = new HashSet<>();
        int storage = 0;
        for (int j : nums){
            if (set.add(j)){
                sum -= j;
            }else {
                storage = j;
            }
        }
        return sum < storage ? new int[]{sum,storage} : new int[]{storage,storage};
    }
}
