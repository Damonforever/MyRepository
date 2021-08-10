package stringCode;

import java.util.Stack;

/**
 * @description: 基础计算器
 * @author: Damon
 * @date 2021/8/9 16:57
 */
public class Solution_calculate {
    public static void main(String[] args) {
        System.out.println(new Solution_calculate().calculate(""));
    }
    public int calculate(String s) {
        int i = 0;
        return helper(s,i)[0];
    }
    int[] helper(String s, int index){
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        char sign = '+';
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (isDigit(ch)){
                sb.append(ch);
                num = Integer.parseInt(sb.toString());
            }
            if (ch == '('){
                int[] res = helper(s,index + 1);
                num = res[0];
                index = res[1];
            }
            //为了把最后一个数字加进去
            if (!isDigit(ch) && ch != ' ' || index == s.length() - 1) {
                switch (sign){
                    case '+':
                        stack.push(+num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = ch;
                sb.delete(0,sb.length());
            }
            if (ch == ')') break;
        }
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return new int[]{sum,index};
    }

    boolean isDigit (char c){
        return c >= '0' && c <= '9';
    }
}
