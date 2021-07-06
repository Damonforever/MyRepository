package matrixCode;

import java.util.HashSet;
import java.util.Set;

public class Solution_setZeroes {
    public void setZeroes(int[][] matrix) {
        Set row = new HashSet();
        Set col = new HashSet();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (Object m: row) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[(int)m][i] = 0;
            }
        }
        for (Object m: col) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][(int)m] = 0;
            }
        }
    }
}
