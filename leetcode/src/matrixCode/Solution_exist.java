package matrixCode;
/*
* 矩阵中的路径
* */

public class Solution_exist {
    public static void main(String[] args) {
        System.out.println(new Solution_exist().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED"));
    }
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        //要查找的串大于已有矩阵大小，必然找不到
        if (m * n < chars.length) return false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == chars[0]){
                    //只有一个字母的串直接返回
                    if (chars.length == 1) return true;
                    boolean flag = backtrack(board,chars,i,j,0);
                    if (flag) return true;
                }
            }
        }
        return false;
    }
    boolean backtrack(char[][] board, char[] chars,int row, int col,int index){
        //这时说明0 ~ n-1都找到了，直接返回
        if (index == chars.length) return true;
        //判断边界
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '0')
            return false;
        char ch = board[row][col];
        if (ch == chars[index]){
            board[row][col] = '0';
            boolean up = backtrack(board, chars, row - 1, col, index + 1);
            boolean down = backtrack(board, chars, row + 1, col, index + 1);
            boolean right = backtrack(board, chars, row, col + 1, index + 1);
            boolean left = backtrack(board, chars, row, col - 1, index + 1);
            if (up || down || left || right) return true;
            board[row][col] = ch;
        }
        return false;
    }
}
