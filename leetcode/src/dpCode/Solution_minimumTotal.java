package dpCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 三角形最小路径和
 * @author: Damon
 * @date 2021/7/16 16:04
 */
public class Solution_minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> nums = new ArrayList<>();
        int n = triangle.size();
        res.add(triangle.get(0).get(0));
        nums.add(new ArrayList<>(res));
        for (int i = 1; i < n; i++) {
            int len = triangle.get(i).size();
            for (int j = 0; j < len; j++) {
                if (j == 0) res.set(j,triangle.get(i).get(j) + nums.get(i - 1).get(j));
                else if (j == len - 1) res.add(triangle.get(i).get(j) + nums.get(i - 1).get(j - 1));
                else res.set(j,triangle.get(i).get(j) + Math.min(nums.get(i - 1).get(j - 1),nums.get(i - 1).get(j)));
                if (i == n - 1) res.set(0,Math.min(res.get(0),res.get(j)));
            }
            nums.add(new ArrayList<>(res));
        }
        return nums.get(n-1).get(0);
    }
}
