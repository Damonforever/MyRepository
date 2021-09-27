package test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/26 20:07
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Stack<String> stack = new Stack<>();
        Stack<String> help = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char fuhao = '-';
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '@' || input.charAt(i) == 'x' || input.charAt(i) == '+'){
                if (input.charAt(i) == '@'){
                    fuhao = input.charAt(i);
                }else {
                    stack.push(String.valueOf(input.charAt(i)));
                }
            }else {
                while (i < input.length() && input.charAt(i) != 'x' && input.charAt(i) != '@' && input.charAt(i) != '+'){
                    sb.append(input.charAt(i));
                    i++;
                }
                if (fuhao == '@'){
                    long num1 = Long.parseLong(stack.pop());
                    num1 = num1 | (num1 + Long.parseLong(sb.toString()));
                    stack.push(String.valueOf(num1));
                    fuhao = '-';
                }else {
                    stack.push(sb.toString());
                }
                sb.delete(0,sb.length());
                if (i != input.length()) i--;
            }
        }
        if (stack.size() > 1){
            while (!stack.isEmpty()){
                if (stack.peek().equals("+") || stack.peek().equals("x")){
                    if (stack.peek().equals("x")){
                        stack.pop();
                        long temp = Long.parseLong(stack.pop()) * Long.parseLong(help.pop());
                        help.push(String.valueOf(temp));
                    }else {
                        stack.pop();
                    }
                }else {
                    help.push(stack.pop());
                }
            }
        }
        if (help.size() > 0){
            long result = 0;
            while (!help.isEmpty()){
                result += Long.parseLong(help.pop());
            }
            help.push(String.valueOf(result));
        }
        System.out.println(help.isEmpty() ? Long.parseLong(stack.peek()) : Long.parseLong(help.peek()));
    }
}
