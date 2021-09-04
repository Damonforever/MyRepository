package bishicode.beike;

import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/3 18:54
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(maxCount(numbers[i]));
        }
    }
    static int maxCount(int n){
        if (n == 1) return 1;
        if (n % 2 == 0) return n/2;
        else return n/2 + 1;
    }

}
