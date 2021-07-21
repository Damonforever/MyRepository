package dpCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 矩阵中的路径
 * @author: Damon
 * @date 2021/7/16 16:34
 */
public class Solution_exist {
    public boolean exist(char[][] board, String word) {
        char c = word.charAt(0);
        Map<Integer,Integer> indexMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == c) indexMap.put(i,j);
            }
        }
        if (indexMap.isEmpty()) return false;
        int count = 1;
        return true;
    }
}
