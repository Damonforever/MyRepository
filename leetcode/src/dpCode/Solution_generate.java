package dpCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 杨辉三角
 * @author: Damon
 * @date 2021/7/15 19:15
 */
public class Solution_generate {
    public static void main(String[] args) {
        System.out.println(generate(3));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        list.add(1);
        lists.add(new ArrayList<>(list));
        if (numRows == 1) return lists;
        for (int i = 1; i < numRows; i++) {
            list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) list.add(1);
                else if (j == i) list.add(1);
                else list.add(lists.get(i - 1).get(j) + lists.get(i - 1).get(j - 1));
            }
            lists.add(list);
        }
        return lists;
    }
}
