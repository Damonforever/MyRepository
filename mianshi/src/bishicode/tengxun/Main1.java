package bishicode.tengxun;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/5 21:14
 */
public class Main1 {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        int[] dp = new int[n];
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = input.nextInt();
//        }
//        if (n <= 2){
//            System.out.println(n - 1);
//            return;
//        }
//        dp[1] = 1;
//        int count = 1;
//        for (int i = 2; i < n; i++) {
//            if (arr[i] <= arr[i -1]) dp[i] = dp[i-1] + 1;
//            else dp[i] = 1;
//            count += dp[i];
//        }
//        System.out.println(count);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n ==1) {
            System.out.println(0);
            return;
        }
        int[] nums = new int[n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int q = 2;
        int res = 0;
        LinkedList<LinkedList<Integer>> min_max = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <= n - 2; i++) {
            LinkedList<Integer> tmp = new LinkedList<>();
            if (nums[i] > nums[i+1]){
                set.add(i);
            }
            for (int j = i; j < i + 2; j++) {
                tmp.addLast(nums[j]);
            }
            res++;
            min_max.addLast(tmp);
        }
        while (q <= n){
            LinkedList<LinkedList<Integer>> min_max_tmp = new LinkedList<>();
            for (int i = 0; i < n - q; i++) {
                if (set.contains(i)) continue;
                LinkedList<Integer> tmp = min_max.removeFirst();
                if (nums[i+q] <= tmp.peekLast()){
                    tmp.removeLast();
                    tmp.add(nums[i + q]);
                    res++;
                }
                min_max_tmp.addLast(tmp);
            }
            min_max = min_max_tmp;
            q++;
        }
        System.out.println(res);
    }

}
