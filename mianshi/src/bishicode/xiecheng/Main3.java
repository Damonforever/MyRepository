package bishicode.xiecheng;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/9 20:42
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String string = sc.nextLine();
        int count  = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[][] nums = new int[m][2];
        while (count < m){
            int l = sc.nextInt();
            int k = sc.nextInt();
            nums[count][0] = l;
            nums[count][1] = k;
            count++;
        }
        int[] dp = new int[n+ 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= nums[i][0]){
                    dp[j] = Math.max(dp[j - nums[i][0]] + nums[i][1], dp[j]);
                }
            }
        }
        int pre = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (string.charAt(i) == '0'){
                sum += dp[i-pre];
                pre = i+1;
            }
        }
        sum += dp[string.length() - pre];
        System.out.println(sum);
    }
}
