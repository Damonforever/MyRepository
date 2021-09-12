package bishicode.xiecheng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/9 20:37
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] numbers = new int[n-1];
        for (int i = 0; i < n - 1; i++) {
            numbers[i] = Math.abs(nums[i] - nums[i+1]);
        }
        Arrays.sort(numbers);
        if (numbers.length - k == 0){
            System.out.println(0);
        }else {
            System.out.println(numbers[numbers.length -k]);
        }
    }
}
