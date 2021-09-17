package bishicode.rongyao;

import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/14 18:12
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()){
            while(sc.hasNext()){
                String input = sc.nextLine();
                String[] strings = input.split(":");
                String name = strings[0];
                String[] stups = strings[1].split(" ");
                int[] nums = new int[stups.length];
                boolean[] yueshu2 = new boolean[nums.length];
                boolean[] yueshu3 = new boolean[nums.length];
                boolean[] yueshu4 = new boolean[nums.length];
                boolean[] yueshu5 = new boolean[nums.length];
                int count2 = 0;
                int count3 = 0;
                int count4 = 0;
                int count5 = 0;
                int sum2 = 0;
                int sum3 = 0;
                int sum4 = 0;
                int sum5 = 0;
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = Integer.parseInt(stups[i]);
                    if (nums[i] > 30000){
                        yueshu2[i] = true;
                        count2++;
                        sum2 += nums[i];
                    }else if (nums[i] > 10000){
                        yueshu3[i] = true;
                        count3++;
                        sum3 += nums[i];
                    }else if (nums[i] > 5000 && nums[i] < 10000){
                        yueshu4[i] = true;
                        count4++;
                        sum4 += nums[i];
                    }else {
                        yueshu5[i] = true;
                        count5++;
                        sum5 += nums[i];
                    }
                }
                if (count2 >= 4){
                    int flag = -1;
                    int counter = 0;
                    for (int i = 0; i < yueshu2.length; i++) {
                        if (yueshu2[i]){
                            if (flag != -1) {
                                flag = i - flag;
                                if (flag >= 5) {
                                    counter++;
                                }
                            }
                            flag = i;
                        }
                    }
                    if (counter >= 3){

                    }
                }

            }
        }else {
            System.out.println("There is no data");
        }
    }

}
