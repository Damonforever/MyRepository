package bishicode.jingdong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/21 19:33
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int num = Integer.parseInt(scanner.nextLine());
//        int count = 0;
//        int max = 0;
//        int[][] indexs = new int[num][2];
//        for (int i = 0; i < num; i++) {
//            String s = scanner.nextLine();
//            String[] strings = s.split(" ");
//            indexs[i][0] = Integer.parseInt(strings[0]);
//            indexs[i][1] = Integer.parseInt(strings[1]);
//            max = Math.max(Math.max(indexs[i][0],indexs[i][1]),max);
//        }
//        int[][] relationships = new int[max+1][max+1];
//        for (int i = 0; i < indexs.length; i++) {
//            relationships[indexs[i][0]][indexs[i][1]] = 1;
//        }
        int count = 0;
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        Integer[][] userArray = new Integer[n][];
        for (int i = 0; i < n; i++) {
            Integer[] arr = Arrays.stream(input.nextLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
            userArray[i] = arr;
        }
        input.close();
        for (int i = 0; i < n; i++) {
            Integer[] base = userArray[i];
            for (int j = i+1; j < n; j++) {
                Integer[] compare = userArray[j];
                if (Math.abs(base[0] - compare[0]) == Math.abs(base[1] - compare[1])){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
