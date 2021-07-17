package dpCode;

/**
 * @description: 矩阵区域和
 * @author: Damon
 * @date 2021/7/17 9:47
 */
public class Solution_matrixBlockSum {
    public static void main(String[] args) {
        int[][] res = matrixBlockSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}},2);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.println(res[i][j]);
            }
        }
    }
    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        for (int i = m-2; i >= 0; i--) {
            mat[i][n-1] = mat[i + 1][n-1] + mat[i][n-1];
        }
        for (int j = n-2; j >= 0; j--) {
            mat[m-1][j] = mat[m-1][j+1] + mat[m-1][j];
        }
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                mat[i][j] = mat[i+1][j] + mat[i][j + 1] - mat[i+1][j+1] + mat[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(i - k, 0);
                int c1 = Math.max(j - k, 0);
                int r2 = Math.min(i + k, m - 1);
                int c2 = Math.min(j + k, n - 1);
                if (r2 < m - 1 && c2 < n - 1){
                    res[i][j] = mat[r1][c1] - mat[r1][c2 + 1] - mat[r2 + 1][c1] + mat[r2 + 1][c2 + 1];
                }else if (r2 == m-1 && c2 == n-1){
                    res[i][j] = mat[r1][c1];
                }else if (r2 < m - 1 && c2 == n - 1){
                    res[i][j] = mat[r1][c1] - mat[r2 + 1][c1];
                }else {
                    res[i][j] = mat[r1][c1] - mat[r1][c2 + 1];
                }
            }
        }
        return res;
    }
    //效率极低
//    public static int[][] matrixBlockSum(int[][] mat, int k) {
//        int m = mat.length;
//        int n = mat[0].length;
//        int[][] res = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                for (int r = i - k; r <= i + k; r++) {
//                    for (int c = j - k; c <= j + k; c++) {
//                        if (r < 0 || r >= m) break;
//                        if (c >=0 && c < n) res[i][j] +=mat[r][c];
//                    }
//                }
//            }
//        }
//        return res;
//    }
}
