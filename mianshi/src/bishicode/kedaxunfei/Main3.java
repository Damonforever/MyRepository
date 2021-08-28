package bishicode.kedaxunfei;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/28 20:19
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.0000000000");
        for (int i = 0; i < n; i++) {
            System.out.println(decimalFormat.format(1-my(nums[i][0],nums[i][1])));
        }
    }
    public static Double my(int l, int r){
        int left = l + 1;
        int right = 61 - l;
        int max = Math.max(left,right);
        int min = 62 - max;
        if (min > r){
            return 0.00;
        }
        if (r >= min && r < max){
            return Math.pow(0.5,r);
        }
        return 2 * Math.pow(0.5,r);
    }

}
