package test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/27 20:31
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(helper(input,0)[0]);
    }
    static int[] helper(String s, int index){
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char change = '*';
        char sign = '&';
        for (; index < s.length(); index++){
            char ch = s.charAt(index);
            if (ch == '!') change = ch;
            if (isDigit(ch)) {
                num = Integer.parseInt("" + ch);
                if (change == '!'){
                    num = ~num;
                    change = '*';
                }
            }
            if (ch == '('){
                int[] res = helper(s,index + 1);
                num = res[0];
                index = res[1];
            }
            if ((!isDigit(ch) && ch != '!') || index == s.length() - 1){
                if (stack.isEmpty()){
                    stack.push(num);
                }else {
                    if (sign == '&'){
                        stack.push(stack.pop() & num);
                    }else {
                        stack.push(stack.pop() | num);
                    }
                }
                sign = ch;
            }
            if (ch == ')') break;
        }
        return new int[]{stack.pop(),index};
    }
    static boolean isDigit(char ch){
        return ch >= '0' && ch <= '1';
    }

}
