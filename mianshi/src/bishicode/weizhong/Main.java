package bishicode.weizhong;

import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/10 20:27
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        long[] nums = new long[T];
        for (int i = 0; i < T; i++) {
            nums[i] = sc.nextLong();
        }
        for (int i = 0; i < T; i++) {
            System.out.println(helper(nums[i]));
            sc.nextLine();
        }
    }
    static String helper(long n){
        for (long i = 1; i <= Math.sqrt(n); i++) {
            for (long j = 1; j <= Math.sqrt(Math.sqrt(n)); j++) {
                long l = (long) (n - Math.pow(i,3) - Math.pow(j,5));
                if (l != 0 && Math.sqrt(Math.sqrt(l)) % 1 == 0) return "YES";
            }
        }
        return "NO";
    }

}
