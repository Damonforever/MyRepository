package bishicode.xiaomi;

import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/1 19:48
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = 3;
        int[] array = new int[n];
        int survive = n;
        int index = 0;
        int count = 0;
        while(survive > 1){
            if (array[index] == 0){
                count++;
                if (count == m){
                    array[index] = 1;
                    count = 0;
                    survive--;
                }
            }
            index++;
            if (index == n){
                index =0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (array[i] == 0){
                System.out.println(i + 1);
            }
        }
    }
}
