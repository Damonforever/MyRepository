package bishicode.meituan;

import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/22 11:25
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[][] max = new int[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            max[i][i] = a[i];
        }
        for (int i = n-2; i>= 0;i--){
            for (int j = n-1; j> 1; j--){
                max[i][j] = Math.max(max[i+1][j],max[i][i]);
            }
        }
        int m = scanner.nextInt();
        int[][] Methods = new int[m][3];
        for (int i = 0; i < m; i++) {
            Methods[i][0] = scanner.nextInt();
            Methods[i][1] = scanner.nextInt();
            Methods[i][2] = scanner.nextInt();
        }
        int[] b = new int[n];
        b[0] = a[0];
        for (int i = 1; i < n; i++) {
            b[i] = b[i-1] + a[i];
        }
        for (int i = 0; i < m; i++) {
            int l = Methods[i][1] - 1;
            int r = Methods[i][2] - 1;
            if (Methods[i][0] == 1){
                if (l==0){
                    System.out.println(b[r]);
                }else {
                    System.out.println(b[r] - b[l-1]);
                }
            }else if (Methods[i][0]==2){
                System.out.println(my(l,r,a,b));
            }else {
                System.out.println(max[l][r]);
            }
        }
    }
    public static int my(int l,int r,int[] a,int[] b){
        int x1= 0;
        for (int j = l; j <= r; j++) {
            if (l==0){
                x1 += Math.pow(b[r] -a[j],2);
            }else {
                x1 += Math.pow(b[r]-b[l-1]-a[j],2);
            }
        }
        return x1;
    }
}
