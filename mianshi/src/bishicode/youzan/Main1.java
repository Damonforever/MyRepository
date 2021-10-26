package bishicode.youzan;

import java.util.Scanner;
import java.util.Stack;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/10 19:25
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '0' || c == '2'){
                stack.push(c);
            }else if (c == '1'){
                if (!stack.isEmpty() && stack.peek() == '0'){
                    stack.pop();
                    count += 2;
                }else {
                    stack.push(c);
                    max = Math.max(max,count);
                    count = 0;
                }
            }else {
                if (!stack.isEmpty() && stack.peek() == '2'){
                    stack.pop();
                    count += 2;
                }else {
                    stack.push(c);
                    max = Math.max(max,count);
                    count = 0;
                }
            }
        }
        max = Math.max(max,count);
        System.out.println(max);

    }
}
