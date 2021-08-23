package bishicode.jingdong;

import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/21 20:33
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String str = sc.next();
        int count, counter;
        for (int i = 1; i <= str.length(); i++) {
            count=0;
            counter=0;
            String string = str.substring(0,i);
            for (int j = 0; j <string.length(); j++) {
                if (string.charAt(j) == '0') count++;
                else counter++;
            }
            System.out.print(my(count,counter,string)+" ");
        }
    }
    public static int my(int a,int b,String s){
        if (s.length() == 0) return 0;
        int cal1 = 0, cal2 = 0;
        int Max = 1;
        if (a == 0 || b==0){
            return s.length();
        }else {
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                max = 0;
                if (s.charAt(i) == '0') cal1++;
                else cal2++;
                if (cal1*b == cal2*a){
                    max = Math.max(1 + my(a - cal1, b-cal2,s.substring(cal1+cal2,s.length())),max);
                }
                Max = Math.max(max,Max);
            }
        }
        return Max;
    }
}
