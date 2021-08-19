package bishicode.liuali;

import java.util.Scanner;

/**
 * @description: 刘老师阿里
 * @author: Damon
 * @date 2021/8/16 18:39
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String input = s1.substring(0,s1.length() - 1);
        sc.close();
        String[] strings = input.split(",");
        String[] strings1 = strings[0].split(" ");
        String fuhao = strings1[0];
        int len = 1;
        if (fuhao.equals("int")){
            len = 4;
        }else if (fuhao.equals("long")){
            len = 8;
        }
        strings[0] = strings1[1];
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            String tmp = strings[i];
            if (tmp.charAt(tmp.length() - 1) == ']'){
                String[] strings2 = tmp.split("\\[");
                int temp = 1;
                for (int j = 1; j < strings2.length; j++) {
                    temp *= Integer.parseInt(strings2[j].substring(0,strings2[j].length() - 1));
                }
                count += temp * len;
            }else {
                count += len;
            }
        }
        System.out.println(count);
    }
}
