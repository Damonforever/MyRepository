package bishicode.xiaomi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/1 19:30
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(",");
        int m = Integer.parseInt(strings[0].substring(2));
        int n = Integer.parseInt(strings[1].substring(2));
        int[] A = new int[m+n];
        int[] B = new int[n];
        String[] stringsA = sc.nextLine().split(",");
        for (int i = 0; i < m; i++) {
            A[i] = Integer.parseInt(stringsA[i]);
        }
        String[] stringsB = sc.nextLine().split(",");
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(stringsB[i]);
        }
        //无赖解法
//        for (int i = m,j = 0; i < m + n; i++,j++) {
//            A[i] = B[j];
//        }
//        Arrays.sort(A);
        int l = m- 1, k = n - 1;
        for (int i = m+n-1; i >= 0; i--){
            if (l == -1){
                A[i] = B[k];
                k--;
            }
            if (k == -1){
                break;
            }
            if (A[l] >= B[k]){
                A[i] = A[l];
                l--;
            }else if (A[l] < B[k]){
                A[i] = B[k];
                k--;
            }
        }
        for (int i = 0; i < m + n; i++) {
            System.out.print(A[i]);
            System.out.print(" ");
        }
    }
}
