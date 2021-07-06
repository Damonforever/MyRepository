package matrixCode;

public class Solution_spiralOrder {
    public static void main(String[] args) {
        int[][] num = new int[][]{{1},
                                  {4}};
       spiralOrder(num);
    }

    static int[] spiralOrder(int[][] matrix) {
        if(matrix.length>0){
            int[] num = new int[(matrix.length*matrix[0].length)];
            int m = -1;
            int len = matrix.length-1;
            int len1 = matrix[0].length-1;
            int init = 0;
            boolean flag = true;
            while (flag){
                if(len-init>0 && len1 - init>0){
                    for(int i = init; i < len1+1; i++){
                        ++m;
                        num[m] = matrix[init][i];
                    }
                    for(int i = init+1; i < len+1; i++){
                        ++m;
                        num[m] = matrix[i][len1];
                    }
                    for(int i = len1-1; i >init; i--){
                        ++m;
                        num[m] = matrix[len][i];
                    }
                    for(int i = len; i>init; i--){
                        ++m;
                        num[m] = matrix[i][init];
                    }
                }
                if (len-init == 0 && flag==true){
                    for (int i = init; i <= len1; i++){
                        ++m;
                        num[m] = matrix[init][i];
                    }
                    flag = false;
                    break;
                }
                if(len1 - init == 0 && flag == true){
                    for (int i = init; i<=len; i++){
                        ++m;
                        num[m] = matrix[i][len1];
                    }
                    flag = false;
                    break;
                }
                init++;
                len--;
                len1--;
                if(init > len || init > len1){
                    break;
                }
            }
            return num;
        }else{
            int[] num = new int[0];
            return num;
        }
    }
}
