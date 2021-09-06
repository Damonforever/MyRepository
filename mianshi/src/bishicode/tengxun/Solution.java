package bishicode.tengxun;

import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/5 20:03
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();
        int[] nums = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            nums[i] = Integer.parseInt("" + input.charAt(i));
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            if (nums[i] == nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }else {


            }
        }
    }
}
