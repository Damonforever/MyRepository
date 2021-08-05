package QueueCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 滑动窗口的最大值
 * @author: Damon
 * @date 2021/8/5 15:24
 */
public class Solution_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) window.push(nums[i]);
            else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
class MonotonicQueue{
    LinkedList<Integer> queue = new LinkedList<>();
    public void push(int n){
        while (!queue.isEmpty() && queue.getLast() < n){
            queue.pollLast();
        }
        queue.addLast(n);
    }
    public int max(){
        return queue.getFirst();
    }
    public void pop(int n){
        if (n == queue.getFirst()) queue.pollFirst();
    }
}
