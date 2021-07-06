package stackCode;

import java.util.Stack;

public class Solution_validateStackSequences {
    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] pop = {4,3,5,1,2};
        System.out.println(validateStackSequences(push,pop));
    }
    static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped.length == 0 && pushed.length == 0){
            return true;
        }
        if(popped.length == 0 || pushed.length == 0){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            //存在一种情况，进栈了一部分，然后全部出栈或者出栈一部分，就需要在while循环中判断
            while (count < popped.length){
                if (!stack.isEmpty() && stack.peek() == popped[count]){
                    stack.pop();
                    count++;
                }else {
                    break;
                }
            }
        }
        while (count < popped.length){
            if (stack.peek() == popped[count]){
                stack.pop();
                count++;
            }else {
                break;
            }
        }
        return stack.isEmpty();

    }
}
