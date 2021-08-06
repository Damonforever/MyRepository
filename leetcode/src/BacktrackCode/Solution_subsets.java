package BacktrackCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 子集
 * @author: Damon
 * @date 2021/8/6 15:38
 */
public class Solution_subsets {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,0,track);
        return res;
    }
    void backtrack(int[] nums, int start, LinkedList<Integer> track){
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums,i + 1,track);
            track.removeLast();
        }
    }
}
