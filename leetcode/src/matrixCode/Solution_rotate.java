package matrixCode;

public class Solution_rotate {
    public static void main(String[] args) {
        int[][] num = {{1,2,3,4,5,6},
                {20,21,22,23,24,7},
                {19,32,33,34,25,8},
                {18,31,36,35,26,9},
                {17,30,29,28,27,10},
                {16,15,14,13,12,11}};
        rotate(num);
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                System.out.println(num[i][j]);
            }
        }
    }


    static void rotate(int[][] matrix) {
        int len = matrix.length-1;
        int init = 0;
        boolean flag = true;
        while (flag){
            if(len-init>1){
                for(int i = init+1; i < len; i++){
                    int temp = matrix[init][i];
                    matrix[init][i] = matrix[i][len];
                    matrix[i][len] = temp;
                }
                for(int j = init+1; j < len; j++){
                    int temp  = matrix[j][init];
                    matrix[j][init] = matrix[len][j];
                    matrix[len][j] = temp;
                }

                for(int k = init+1,n = len-1; k < len; k++,n--){
                    int temp  = matrix[init][k];
                    matrix[init][k] = matrix[len][n];
                    matrix[len][n] = temp;
                }
            }
            if (len-init>0){
                int temp = matrix[init][init];
                matrix[init][init] = matrix[init][len];
                matrix[init][len] = temp;
                temp = matrix[len][init];
                matrix[len][init] = matrix[len][len];
                matrix[len][len] = temp;
                temp = matrix[init][init];
                matrix[init][init] = matrix[len][len];
                matrix[len][len] = temp;
            }
            init++;
            len--;
            if(init>=len){
                flag=false;
            }
        }

    }
}
