package matrixCode;

public class Solution_findNumberIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {{1,4,7,11,15}};
        System.out.println(findNumberIn2DArray(arr,15));
    }
    static boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean flag = false;
        int row = matrix.length;
        if(row == 0) return false;
        int col = matrix[0].length;
        //行和列中找到最小的值
        int scale = Math.min(row,col);
        int count = 0;
        //在对角线中查找，不存在的话可以判断target可能存在区域
        for (int i = 0; i < scale; i++) {
            if (matrix[i][i] == target){
                flag = true;
                break;
            }
            if (matrix[i][i] > target) break;
            count++;
        }
        if(flag) return true;
        //row == col很重要，用于判断是否需要遍历长宽不等的可能区域
        if(count == scale && row == col) return false;
        //对两个区域进行遍历
        for (int i = 0; i < row; i++){
            for (int j = count; j < col; j++){
                if(matrix[i][j] == target){
                    flag = true;
                    break;
                }
            }
        }
        if(!flag){
            for (int i = count; i < row; i++){
                for (int j = 0; j < count; j++){
                    if(matrix[i][j] == target){
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }
}
