package bishicode.ali;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/27 19:07
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] number = sc.nextLine().split(" ");
        long n = Long.parseLong(number[0]);
        long k = Long.parseLong(number[1]);
        String input = sc.nextLine();
        String[] strings = input.split(" ");
        long[] nums = new long[strings.length];

        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(strings[i]);
        }
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            k -= (nums[i + 1] - nums[i]) * (i + 1);
            if (k <= 0) break;
        }
        if (k <= 0){
            System.out.println(nums[Math.toIntExact(n - 1)]);
            return;
        }else {
            if (k % nums.length == 0){
                System.out.println(nums[Math.toIntExact(n - 1)] + k / n);
            }else {
                System.out.println(nums[Math.toIntExact(n - 1)] + k / n + 1);
            }
        }

    }
}
