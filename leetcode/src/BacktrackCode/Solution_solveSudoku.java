package BacktrackCode;

import java.util.Arrays;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/6 19:55
 */
public class Solution_solveSudoku {
    public void solveSudoku(char[][] board) {
        backtrack(0,0,board);
    }
    boolean backtrack(int row, int col,char[][] board){
        int m = 9, n = 9;
        //穷举到最后一列需要换行
        if (col == n) return backtrack(row + 1, 0,board);
        //找到一个可行解，触发base case
        if (row == m) return true;
        //有预设数字不用管
        if (board[row][col] != '.') return backtrack(row, col + 1, board);
        for (char ch = '1'; ch <= '9'; ch++){
            //不合法就跳过
            if (!isValid(board,row,col,ch)) continue;
            board[row][col] = ch;
            //找到可行解立即返回
            if (backtrack(row,col + 1, board)) return true;
            board[row][col] = '.';
            //穷举完1~9，依然没有找到可行解，需要前面的格子换个数字穷举
        }
        return false;
    }
    boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            //判断行是否重复
            if (board[row][i] == ch) return false;
            //判断列是否重复
            if (board[i][col] == ch) return false;
            //判断3 x 3方格是否重复
            if (board[(row/3)*3+i/3][(col/3)*3 + i%3] == ch) return false;
        }
        return true;
    }
}
