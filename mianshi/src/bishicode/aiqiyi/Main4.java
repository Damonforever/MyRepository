package bishicode.aiqiyi;

import java.util.Stack;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/12 19:50
 */
public class Main4 {
    public static void main(String[] args) {
        System.out.println(helper(new int[]{500,300,800,300,270,570}));
    }
    static int[] helper(int[] nums){
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0){
                Stack <Integer> stack1 = new Stack<>();
                stack1.push(nums[i]);
                for (int j = i+1; j < len; j++) {
                    if (j == i + 1){
                        stack1.push(nums[j]);
                    }else {
                        if (nums[j] > stack1.peek()){
                            stack1.push(nums[j]);
                        }
                    }
                }
                res[i] = stack1.size();
            }else if (i == len-1){
                Stack <Integer> stack1 = new Stack<>();
                stack1.push(nums[i]);
                for (int j = len - 2; j >= 0; j--) {
                    if (j == len - 2){
                        stack1.push(nums[j]);
                    }else {
                        if (nums[j] > stack1.peek()){
                            stack1.push(nums[j]);
                        }
                    }
                }
                res[i] = stack1.size();
            }else {
                Stack <Integer> stack1 = new Stack<>();
                Stack <Integer> stack2 = new Stack<>();
                stack1.push(nums[i]);
                for (int j = i+1; j < len; j++) {
                    if (j == i + 1){
                        stack1.push(nums[j]);
                    }else {
                        if (nums[j] > stack1.peek()){
                            stack1.push(nums[j]);
                        }
                    }
                }
                for (int j = i-1; j >= 0; j--) {
                    if (j == i-1){
                        stack2.push(nums[j]);
                    }else {
                        if (nums[j] > stack2.peek()){
                            stack2.push(nums[j]);
                        }
                    }
                }
                res[i] = stack1.size() + stack2.size();
            }
        }
        return res;
    }
}
