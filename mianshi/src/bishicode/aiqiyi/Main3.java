package bishicode.aiqiyi;

import java.util.Scanner;
import java.util.Stack;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/12 16:03
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String string = sc.nextLine();
        Stack<Character> stack0 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int num1 = 0;
        int num3 = 0;
        for (int i = 0; i < n; i++) {
            if (string.charAt(i) == '1') num1++;
            if (string.charAt(i) == '3') num3++;
        }
        int counter = 0;
        for (int i = 0; i < n; i++) {
            char c = string.charAt(i);
            if (c == '0'){
                stack0.push(c);
            }else if (c == '2'){
                stack2.push(c);
            }else if (c == '1'){
                if (!stack0.isEmpty()){
                    if (stack2.isEmpty() || num1 >= num3){
                        stack0.pop();
                        counter++;
                    }
                }
                num1--;
            }else {
                if (!stack2.isEmpty()){
                    if (stack0.isEmpty() || num3 >= num1){
                        stack2.pop();
                        counter++;
                    }
                }
                num3--;
            }
        }
        System.out.println(counter *2);

    }
    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if(s.length() > 1){
            dp[1] = 1;
            if(s.substring(0,2).compareTo("26") <= 0 && s.substring(0,2).compareTo("10") >= 0) dp[1] = 2;
            for (int i = 0; i < s.length(); i++) {
                int c = 0;
                if(i == 0 || i == 1) continue;
                if(s.substring(i-1,i+1).compareTo("26") <= 0 && s.substring(i-1,i + 1).compareTo("10") >= 0) c = 1;
                dp[i] = dp[i - 1] + dp[i - 2]*c;
            }
        }
        return dp[s.length()-1];
    }
}
