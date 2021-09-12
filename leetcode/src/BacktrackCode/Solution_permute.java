package BacktrackCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 全排列
 * @author: Damon
 * @date 2021/7/14 9:04
 */
public class Solution_permute {
    public static void main(String[] args) {
        List<List<Integer>> res = permute( new int[]{1,3,5,7,9});
        int sum = 0;
        int value;
        for (int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
             value = 0;
            for (int j = 0; j < list.size(); j++) {
                value = value * 10 + list.get(j);
            }
            sum += value;
        }
        System.out.println(sum);
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
