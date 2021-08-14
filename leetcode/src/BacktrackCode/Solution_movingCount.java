package BacktrackCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 机器人的运动范围
 * @author: Damon
 * @date 2021/8/12 15:35
 */
public class Solution_movingCount {
    public static void main(String[] args) {
        System.out.println(new Solution_movingCount().movingCount(11,8,16));
    }
    public int movingCount(int m, int n, int k) {
        int[][] nums = new int[m][n];
        return backtrack(0,0,m,n,k,nums);
    }
    int backtrack(int row, int col,int m, int n,int k,int[][] nums){
        if (row < 0 || row >= m || col < 0 || col >= n || nums[row][col] == 1 || !isValid(row,col,k)) return 0;
        nums[row][col] = 1;
        return 1 + backtrack(row - 1, col, m, n, k, nums) + backtrack(row + 1, col, m, n, k, nums) +
                backtrack(row, col - 1, m, n, k, nums) + backtrack(row, col + 1, m, n, k, nums);
    }
    boolean isValid(int row, int col,int k){
        int sum = 0;
        while (row != 0){
            int temp = row % 10;
            sum += temp;
            row = (row - temp) / 10;
        }
        while (col != 0){
            int temp = col % 10;
            sum += temp;
            col = (col - temp) / 10;
        }
        return sum <= k;
    }
}
