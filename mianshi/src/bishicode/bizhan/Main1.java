package bishicode.bizhan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/25 20:16
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        ArrayList<Integer[]> list = new ArrayList<>();
        do {
            String s = sc.nextLine();
            if (s.equals("")) break;
            String[] split = s.split(",");
            Integer[] nums = new Integer[split.length];
            for (int i = 0; i < split.length; i++) {
                nums[i] = Integer.parseInt(split[i]);
            }
            count++;
            list.add(nums);
        }while (true);
        Integer[][] ints = new Integer[count][];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
    }

}
