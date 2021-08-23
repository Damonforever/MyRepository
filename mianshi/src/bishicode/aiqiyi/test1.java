package bishicode.aiqiyi;

import bishicode.wangyi.Main;

import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/22 16:07
 */
public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String[] strings = scanner.nextLine().split(",");
            int[] numbers = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                numbers[i] = Integer.parseInt(strings[i]);
            }
            int max = numbers[0];
            int min = numbers[0];
            int count = 0;
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] >= max){
                    max = numbers[i];
                }else {
                    count = Math.max(count,max-min);
                    min = numbers[i];
                    max = numbers[i];
                }
            }
            if (count == 0) count = max -min;
            System.out.println(count);
        }
    }
}
