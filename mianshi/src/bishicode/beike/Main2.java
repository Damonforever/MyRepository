package bishicode.beike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/3 19:04
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= m){
                index = i;
                break;
            }
        }
//        index--;
        long counter = 0;
        n = n -1;
        int left = n;

        int temp = 0;
        counter += nums[n];
        while (n > 0){
            for (int i = index - 1; i >= index - k; i--){
                if (i >= 0){
                    temp += nums[i];
                }
            }
            if (nums[left - 1] > temp && nums[left - 1] > m){
                counter += nums[left - 1];
                n = n-k-1;
                left--;
            }else if (n >= k){
                counter += temp;
                n = n-k;
                index -= k;
            }else {
                counter += nums[index];
                n--;
                index--;
            }
            temp = 0;
        }
        System.out.println(counter);
    }
}
