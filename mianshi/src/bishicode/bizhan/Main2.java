package bishicode.bizhan;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/25 21:59
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] ints = new int[2][2];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < 2; j++) {
                ints[i][j] = sc.nextInt();
            }
        }
        long a = ints[0][0] + ints[1][0];
        long b = ints[0][1] + ints[1][1];
        HashMap<Long, Integer> map = new HashMap<>();
        long max = 0;
    }
}
