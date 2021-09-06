package bishicode.tengxun;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/5 20:47
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            B[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            A[i] = helper(A[i]);
        }
        for (int i = 0; i < n; i++) {
            B[i] = helper(B[i]);
        }
        Arrays.sort(B);
        Arrays.sort(A);
        int sum = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            while (k < n){
                if (A[k] > B[i]){
                    sum++;
                    k++;
                    break;
                }
                k++;
            }
        }
        System.out.println(sum);
    }
     static int helper(int q){
        int sum = 0;
        for (int i = 1; i <= Math.sqrt(q); i++){
            if (q % i == 0){
                if (i != Math.sqrt(q)) sum += 2;
                else sum++;
            }
        }
        return sum;
    }
}
