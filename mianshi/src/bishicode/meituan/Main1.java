package bishicode.meituan;

import java.util.Scanner;
import java.util.Stack;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/22 10:51
 */
/* 测试用例
* ()(())()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()(())()()(())()()((()))(())()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()(())
* */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(my(input));
        sc.close();
    }
    public static int my(String s){
        long count  = 1;
        int P = 1000000007;
        Stack<String> stack = new Stack<>();
        String[] strings = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            strings[i] = s.substring(i,i+1);
        }
        for (String string : strings) {
            if (string.equals(")")) {
                if (!stack.peek().equals("(")) {
                    long num = Long.parseLong(stack.pop()) + 1;
                    stack.pop();
                    num = num % P;
                    stack.push("" + num);
                } else {
                    stack.pop();
                    long num = 2;
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        num *= Long.parseLong(stack.pop());
                        num %= P;
                    }
                    stack.push("" + num);
                }
            } else {
                stack.push(string);
            }
        }
        while (!stack.isEmpty()){
            count *= Long.parseLong(stack.pop());
            count %= P;
        }
        return (int) count;
    }
}
