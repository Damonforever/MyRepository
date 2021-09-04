package bishicode.beike;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/3 18:03
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n-- >0){
            int len = Integer.parseInt(sc.nextLine());
            String s = sc.nextLine();
            char[] chars = s.toCharArray();
            LinkedList<Character> stack = new LinkedList<>();
            int result = 0;
            for (int i = 0; i < len; i++) {
                if (chars[i] == '('){
                    stack.push(chars[i]);
                }
                if (chars[i] == ')'){
                    if (stack.isEmpty()){
                        result++;
                    }else {
                        stack.pop();
                    }
                }
            }
            System.out.println(result);
        }
//        int count = 0;
//        while(count <= n){
//            int len = Integer.parseInt(sc.nextLine());
//            String str = sc.nextLine();
//            int max = 0;
//            int[] dp = new int[str.length()];
//            for (int i = 1; i < len; i++) {
//                if (str.charAt(i) == ')'){
//                    if (str.charAt(i) == '('){
//                        dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
//                    }else if (i - dp[i - 1] > 0 && str.charAt(i-dp[i-1] - 1) == '('){
//                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i-dp[i -1] - 2] : 0) + 2;
//                    }
//                    max = Math.max(max,dp[i]);
//                }
//            }
//            int sum = 0;
//            for (int i = 1; i < dp.length; i++) {
//
//            }
//            System.out.println((str.length() - max)/2);
//            count++;
//        }
    }
}
