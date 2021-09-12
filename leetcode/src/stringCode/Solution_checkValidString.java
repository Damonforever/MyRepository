package stringCode;

import java.util.Stack;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/12 20:59
 */
public class Solution_checkValidString {
    public static void main(String[] args) {
        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        System.out.println(checkValidString(s));
    }
    public static boolean checkValidString(String s) {
        int len  =  s.length();
        Stack<Character> stack = new Stack<>();
        int counter = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*'){
                stack.push(s.charAt(i));
                if (s.charAt(i) == '(') counter++;
            }else {
                if (!stack.isEmpty()){
                    if (stack.peek() == '('){
                        stack.pop();
                        counter--;
                    }else {
                        if (stack.size() > 1 && counter > 0){
                            int count = 0;
                            while (true){
                                if (stack.peek() != '('){
                                    stack.pop();
                                    count++;
                                }else break;
                            }
                            stack.pop();
                            counter--;
                            while (count > 0){
                                count--;
                                stack.push('*');
                            }
                        }else {
                            stack.pop();
                            if(counter > 0) counter--;
                        }
                    }
                }else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }else {
            if (counter == 0) return true;
            else {
                int count = 0;
                while (!stack.isEmpty()){
                    if (stack.pop() == '*'){
                        count++;
                    }else {
                        if (count > 0) count--;
                        else return false;
                    }
                }
                return true;
            }
        }
    }
}
