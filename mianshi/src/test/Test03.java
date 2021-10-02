package test;

import java.util.Stack;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/28 15:30
 */
public class Test03 {
    public static void main(String[] args) {
        System.out.println(helper("3[m]2[t]"));
    }
    public static String helper(String s){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                StringBuilder sb = new StringBuilder();
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    sb.append(s.charAt(i));
                    i++;
                }
                stack.push(sb.toString());
                if (i != s.length()) i--;
            }else if (s.charAt(i) == '['){
                stack.push("[");
            }else if (s.charAt(i) == ']'){
                String tmp = stack.pop();
                StringBuilder sb = new StringBuilder();
                stack.pop();
                int val = Integer.parseInt(stack.pop());
                for (int j = 0; j < val; j++) {
                    sb.append(tmp);
                }
                if (!stack.isEmpty()){
                    stack.push(stack.pop() + sb);
                }else {
                    stack.push(sb.toString());
                }
            }else {
                StringBuilder sb = new StringBuilder();
                while (i < s.length() && s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                     sb.append(s.charAt(i));
                    i++;
                }
                stack.push(sb.toString());
                if (i != s.length()) i--;
            }
        }
        return stack.peek();
    }
}
