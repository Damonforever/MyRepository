package bishicode.baidu;

import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/7 19:42
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            int k = input.length();
            StringBuilder sb = new StringBuilder();
            int jiewei = 0;
            for (int j = k -1; j >= 0; j--) {
                if (Integer.parseInt(input.charAt(j) + "") > 0){
                    if (Integer.parseInt(input.charAt(j) + "") >1){
                        if (Integer.parseInt(input.charAt(j) + "") > 2){
                            if (jiewei == 0){
                                sb.append(3);
                            }else {
                                if (Integer.parseInt(input.charAt(j) + "") - 1 >= 3){
                                    sb.append(3);
                                }else {
                                    sb.append(2);
                                }
                                jiewei = 0;
                            }
                        }else {
                            if (jiewei == 0){
                                sb.append(2);
                            }else {
                                sb.append(1);
                                jiewei = 0;
                            }
                        }
                    }else {
                        if (jiewei == 0){
                            sb.append(1);
                        }else {
                            if (j == 0){
                                break;
                            }
                            sb.append(3);
                            jiewei = 1;
                        }
                    }
                }else {
                    if (jiewei == 0){
                        sb.append(3);
                        jiewei = 1;
                    }else {
                        sb.append(3);
                        jiewei = 1;
                    }
                }
            }
            sb = sb.reverse();
            System.out.println(Long.parseLong(sb.toString()));
        }
        sc.close();
    }
}
