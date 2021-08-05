package stackCode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description: 下一个更大元素 II
 * @author: Damon
 * @date 2021/8/5 10:06
 */
public class Solution_nextGreaterElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,2,1})));
    }
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            ans[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return ans;
    }
}
