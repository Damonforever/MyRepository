package bishicode.kedaxunfei;

import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/28 20:01
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = new int[n];
        String[] strings = sc.nextLine().split(" ");
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        int max = 0;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]){
                count++;
            }else if (i + 2 < nums.length && nums[i] == nums[i+ 2]){
                count++;
                max = Math.max(max,count);
                count = 1;
            }else {
                max = Math.max(max,count);
                count = 1;
                if (i - 1 > 0 && i + 1 < nums.length && nums[i + 1] == nums[i -1]) count++;
            }
        }
        max = Math.max(max,count);
        System.out.println(max);
    }
}
