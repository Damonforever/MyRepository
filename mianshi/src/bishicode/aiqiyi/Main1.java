package bishicode.aiqiyi;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/1 16:32
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine();
        String[] strings = str.split(",");
        String[] strings1 = strings[strings.length-1].split(":");
        int n = Integer.valueOf(strings1[strings1.length-1]);
        strings[strings.length-1] = strings1[0];
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.valueOf(strings[i]);
        }
        double max = sum(arr,n);
        DecimalFormat decimalFormat = new DecimalFormat("0.00%");
        String s = decimalFormat.format(max);
        System.out.println(s);
    }
    private static  double sum(int[] arr,int n){
        if (arr.length == 0 || n == 0) return 0;
        double max = 0;
        double total = 0;
        for (int i = 0; i < n; i++) {
            total += arr[i];
        }
        for (int i = n; i < arr.length; i++) {
            double temp = total - arr[i - n] + arr[i];
            double aver = (temp / total) - 1;
            total = temp;
            if (aver > max) max = aver;
        }
        return max;
    }
}
