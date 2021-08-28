package bishicode.ali;

import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/27 19:43
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] strings = input.split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        int count = 0;
        int[][] nums = new int[n][m];
        while (count < n){
            String input1 = sc.nextLine();
            String[] strings1 = input1.split(" ");
            int[] nums1 = new int[m];
            for (int i = 0; i < m; i++) {
                nums1[i] = Integer.parseInt(strings1[i]);
            }
            nums[count] = nums1;
            count++;
        }
        int k = Integer.parseInt(sc.nextLine());
        count = 0;
        int[][] indexes = new int[k][2];
        while (count < k){
            String input1 = sc.nextLine();
            String[] strings1 = input1.split(" ");
            int[] nums1 = new int[m];
            for (int i = 0; i < m; i++) {
                nums1[i] = Integer.parseInt(strings1[i]);
            }
            indexes[count] = nums1;
            count++;
        }
        System.out.println(-1);
    }
}
