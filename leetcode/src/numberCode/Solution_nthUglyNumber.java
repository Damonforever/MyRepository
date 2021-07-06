package numberCode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @description: 丑数
 * @author: Damon
 * @date 2021/6/30 16:08
 */
public class Solution_nthUglyNumber {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
//        if (n == 1) return 1;
//        int count = 1;
//        int num = 2;
//        boolean flag = false;
//        while (count < n){
//            int temp = num;
//            while (temp != 1){
//                if (temp % 5 == 0){
//                    temp = temp/5;
//                    flag = true;
//                }
//                if (temp % 3 == 0){
//                    temp = temp/3;
//                    flag = true;
//                }
//                if (temp % 2 == 0){
//                    temp = temp/2;
//                    flag = true;
//                }
//                if (!flag) break;
//                flag = false;
//            }
//            if (temp == 1) count++;
//            num++;
//        }
//        return num-1;
        //最小堆
//        int[] factors = {2, 3, 5};
//        Set<Long> seen = new HashSet<Long>();
//        PriorityQueue<Long> heap = new PriorityQueue<Long>();
//        seen.add(1L);
//        heap.offer(1L);
//        int ugly = 0;
//        for (int i = 0; i < n; i++) {
//            long curr = heap.poll();
//            ugly = (int) curr;
//            for (int factor : factors) {
//                long next = curr * factor;
//                if (seen.add(next)) {
//                    heap.offer(next);
//                }
//            }
//        }
//        return ugly;

    }
}
