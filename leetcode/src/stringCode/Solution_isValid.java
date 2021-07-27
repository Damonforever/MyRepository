package stringCode;

import java.util.Stack;

/**
 * @description: 有效字符串
 * @author: Damon
 * @date 2021/7/26 21:11
 */
public class Solution_isValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')'){
                if (stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            }else if (s.charAt(i) == ']'){
                if (stack.isEmpty() || stack.peek() != '[') return false;
                stack.pop();
            }else if (s.charAt(i) == '}'){
                if (stack.isEmpty() || stack.peek() != '{') return false;
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
