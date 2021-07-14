package BacktrackCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 全排列
 * @author: Damon
 * @date 2021/7/14 9:04
 */
public class Solution_permute {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track,res);
        return res;
    }
    static void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> res){
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) continue;
            track.add(num);
            backtrack(nums, track, res);
            track.removeLast();
        }
    }
}
