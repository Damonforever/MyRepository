package test;

import java.util.*;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/15 19:12
 */
public class Test02 {

    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{-1,3,2,0}));
    }
    public static int my(){
        Integer num = 0;
        try {
            num = null;
            return num;
        }catch (Exception e){
            return 1;
        }finally {
            return 2;
        }
    }
    public static int find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> candidateK = new LinkedList<Integer>();
        candidateK.push(nums[n - 1]);
        int maxK = Integer.MIN_VALUE;
        int count = 0;
        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] < maxK) {
                count++;
                maxK = Integer.MIN_VALUE;
                candidateK = new LinkedList<>();
                candidateK.push(nums[i + 1]);
            }
            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }
            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }

        return count;
    }
}
