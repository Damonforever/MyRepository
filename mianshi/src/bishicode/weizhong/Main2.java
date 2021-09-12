package bishicode.weizhong;

import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/10 21:13
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int[] array2 = new int[n];
        int temp1 = array[0];
        int temp2 = 0;
        array2[0] = array[0];
        for (int i = 1; i < n; i++) {
            if ((i + 1) % 2 == 0){
                array2[i] = temp1 - temp2 -array[i];
                temp2 += array2[i];
            }else {
                array2[i] = array[i] + temp2 -temp1;
                temp1 += array2[i];
            }

        }
        for (int i = 0; i < n; i++) {
            System.out.print(array2[i] + " ");
        }
    }
}
