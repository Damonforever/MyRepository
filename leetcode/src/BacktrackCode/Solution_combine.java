package BacktrackCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 组合
 * @author: Damon
 * @date 2021/8/6 16:02
 */
public class Solution_combine {
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new Solution_combine().combine(1,1));
    }
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(1,n,k,track);
        return res;
    }
    void backtrack(int start, int n,int k, LinkedList<Integer> track){
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(i + 1,n,k,track);
            track.removeLast();
        }
    }
}
