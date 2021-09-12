package bishicode.xiecheng;

import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/9 19:13
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("\\");
        while (count < n){
            String s =sc.nextLine();
            if (sb.charAt(sb.length() -1) == '\\'){
                if (s.equals("pwd")){
                    System.out.println(sb.toString());
                }else if (s.endsWith(".")){

                }else {
                    String[] strings = s.split(" ");
                    sb.append(strings[1]);
                }
            }else {
                if (s.equals("pwd")){
                    System.out.println(sb.toString());
                }else if (s.endsWith(".")){
                    while (sb.charAt(sb.length() - 1) != '\\'){
                        sb.delete(sb.length() -1,sb.length());
                    }
                    if (sb.length() != 1) sb.delete(sb.length() -1,sb.length());
                }else {
                    String[] strings = s.split(" ");
                    sb.append('\\').append(strings[1]);
                }
            }
            count++;
        }
    }
}
