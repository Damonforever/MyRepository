package bishicode.bizhan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/25 20:45
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(",");
        int column = str.length;
        int row = 1;
        int[] temp = new int[column];
        for (int i = 0; i < column; i++) {
            temp[i] = Integer.parseInt(str[i]);
        }
        ArrayList<int[]> list = new ArrayList<>();
        list.add(temp);
        while (sc.hasNext()) {
            s = sc.nextLine();
            str = s.split(",");
            temp = new int[column];
            for (int i = 0; i < column; i++) {
                temp[i] = Integer.parseInt(str[i]);
            }
            list.add(temp);
            row++;
        }
        int[][] nums = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                nums[i][j] = list.get(i)[j];
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == 1) {
                    res++;
                    infect(nums, i, j);
                }
            }
        }
        System.out.println(res);
    }

    private static void infect(int[][] nums, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length) {
            return;
        }
        if (nums[i][j] == 1) {
            nums[i][j] = 2;
            infect(nums, i + 1, j);
            infect(nums, i - 1, j);
            infect(nums, i, j - 1);
            infect(nums, i, j + 1);
        }

    }
}
