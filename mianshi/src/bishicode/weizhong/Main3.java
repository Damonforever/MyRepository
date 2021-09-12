package bishicode.weizhong;

import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/10 21:21
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine();
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        String zhiling = sc.nextLine();
        int len = zhiling.length();
        int a = 0, b = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            char fx = zhiling.charAt(i);
            if (i > 0 && fx != zhiling.charAt(i-1)) res += x;
            if (fx == 'h'){
                if (b == 0 || nums[a][b -1] == -1){
                    res += y;
                }else {
                    res += Math.max(nums[a][b],nums[a][b -1]);
                    b--;
                }
            }
            if (fx == 'j'){
                if (a == n-1 || nums[a +1][b] == -1){
                    res += y;
                }else {
                    res += Math.max(nums[a][b],nums[a+1][b]);
                    a++;
                }
            }
            if (fx == 'k'){
                if (a == 0 || nums[a-1][b] == -1){
                    res += y;
                }else {
                    res += Math.max(nums[a][b],nums[a-1][b]);
                    a--;
                }
            }
            if (fx == 'l'){
                if (b == m-1 || nums[a][b+1] == -1){
                    res += y;
                }else {
                    res += Math.max(nums[a][b],nums[a][b+1]);
                    b++;
                }
            }
        }
        System.out.println(res);
    }
}
