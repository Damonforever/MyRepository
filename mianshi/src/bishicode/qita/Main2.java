package bishicode.qita;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/25 19:45
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        int count = 0;
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();
        char[][] chars = new char[row][col];
        for (int i = 0; i < row; i++) {
            chars[i] = sc.nextLine().toCharArray();
        }
        HashMap<Character, Integer[]> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                if (chars[i][j] == '_') continue;
                map.put(chars[i][j],new Integer[]{i,j});
            }
        }
        while (count < T){
            int res = 0;
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); i++) {
                Integer[] help;
                Integer[] help1;
                if (i == 0){
                    help = map.get(s.charAt(i));
                    res += help[0] + help[1] + 1;
                }else {
                    help = map.get(s.charAt(i));
                    help1 = map.get(s.charAt(i-1));
                    res += (Math.abs(help1[0] - help[0]) + Math.abs(help1[1] - help[1])) + 1;
                }
            }
            System.out.println(res);
            count++;
        }
    }
}
