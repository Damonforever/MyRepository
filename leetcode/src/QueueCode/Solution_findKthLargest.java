package QueueCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/31 9:25
 */
public class Solution_findKthLargest {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            queue.add(num);
        }
        for (int i = 0; i < k - 2; i++) {
            queue.poll();
        }
        return queue.poll();
    }
}
