package bishicode.liumt;

import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/15 9:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(longestPalindrome(s));
        sc.close();
    }
     static int longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
         for (int i = 0; i < s.length(); i++) {
             sb.append(s.charAt(s.length() -1 -i));
         }
         String s1 = sb.toString();
         int n = s1.length();
         int base = 131, mod = 1000000007;
         int left = 0, right = 0, mul = 1;
         int best = -1;
         for (int i = 0; i < n; ++i) {
             left = (int) (((long) left * base + s1.charAt(i)) % mod);
             right = (int) ((right + (long) mul * s1.charAt(i)) % mod);
             if (left == right) {
                 best = i;
             }
             mul = (int) ((long) mul * base % mod);
         }
         String add = (best == n - 1 ? "" : s1.substring(best + 1));
         StringBuffer ans = new StringBuffer(add).reverse();
         ans.append(s1);
         return ans.length() - s.length();
    }
}
