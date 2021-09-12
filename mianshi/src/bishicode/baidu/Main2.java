package bishicode.baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/7 20:37
 */
public class Main2 {
    static List<String> list =new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String string = sc.nextLine();

    }
    static void sub(char[] chars, int i, String res,int k){
        if (i ==  chars.length){
            if (res.length() < k) return;

        }
        sub(chars,i + 1, res ,k);
        sub(chars,i + 1, res +chars[i] ,k);
    }

}
