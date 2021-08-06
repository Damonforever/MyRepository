package BacktrackCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: N皇后
 * @author: Damon
 * @date 2021/7/14 9:23
 */
public class Solution_solveNQueens {
    public static void main(String[] args) {
        List<List<String>> res = solveNQueens(4);
        res.forEach( i -> i.forEach(System.out::println));
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        //初始化棋盘，每个位置都是'.'即棋盘是空的
        List<String> track = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }
        for (int i = 0; i < n; i++) {
            track.add(sb.toString());
        }
        backtrack(0,track,res,n);
        return res;
    }
    static void backtrack(int row, List<String> track, List<List<String>> res, int n){
        //递归至最后一行，将其加入结果集
        if (row == track.size()){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int col = 0; col < n; col++) {
            //选择不合法就排除
            if (!isValid(track,row,col)) continue;
            //替换对应位置的字符
            StringBuilder sb = new StringBuilder(track.get(row));
            sb.replace(col,col+1,"Q");
            track.set(row,sb.toString());
            //递归进入下个决策点
            backtrack(row + 1,track,res,n);
            //撤销替换
            sb.replace(col,col+1,".");
            track.set(row,sb.toString());
        }
    }
    static boolean isValid(List<String> track, int row, int col){
        int n = track.size();
        //检查列中是否有皇后互相冲突
        for (int i = 0; i < row; i++) {
            if (track.get(i).charAt(col) == 'Q') return false;
        }
        //检查右上方是否有皇后冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if (track.get(i).charAt(j) == 'Q') return false;
        }
        //检查左上方是否有皇后冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if (track.get(i).charAt(j) == 'Q') return false;
        }
        return true;
    }
}
