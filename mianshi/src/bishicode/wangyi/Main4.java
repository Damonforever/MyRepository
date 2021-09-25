package bishicode.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/18 14:25
 */
public class Main4 {
    static int count  = 0, state;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L1 = sc.nextInt();
        int L2 = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        String start = sc.nextLine();
        String input = sc.nextLine();
        System.out.println();
    }
    static int helper(String start, String input, int M){
        int L1 = start.length();
        char[] array = new char[(L1 << 1) - 1];
        for (int i = 0; i < start.length(); i++) {
            array[i << 1] = start.charAt(i);
            state ^= 1 << (i << 1);
        }
        char[] inputs = input.toCharArray();
        Arrays.sort(inputs);
        return 0;

    }
    static void method(char[] array, char[] inputs, int len){

    }
}
