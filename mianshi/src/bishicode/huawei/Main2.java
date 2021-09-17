package bishicode.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/15 19:06
 */
public class Main2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] input1 = sc.nextLine().split(" ");
//        int[] work = new int[input1.length];
//        for (int i = 0; i < input1.length; i++) {
//            work[i] = Integer.parseInt(input1[i]);
//        }
//        String[] input2 = sc.nextLine().split(" ");
//        int[] ste = new int[input2.length];
//        for (int i = 0; i < input2.length; i++) {
//            ste[i] = Integer.parseInt(input2[i]);
//        }
//        System.out.println(helper(work,ste));
        int[] work = new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
        int[] ste = new int[]{823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
        System.out.println(helper1(work,ste));
    }
    static int helper(int[] work, int[] ste){
        Arrays.sort(work);
        Arrays.sort(ste);
        int index = 0;
        int i = 0;
        for (int w : work) {
            while (i < ste.length && ste[i] < w){
                i++;
            }
            if (i == 0) index = Math.max(index,ste[i] - w);
            else if (i == ste.length) return Math.max(index,work[work.length - 1] - ste[ste.length - 1]);
            else index = Math.max(index,Math.min(ste[i] - w, w - ste[i - 1]));

        }
        return index;
    }
    static int helper1(int[] work, int[] ste){
        Arrays.sort(work);
        Arrays.sort(ste);
        int temp = ste[0] - work[0];
        for (int i = 1; i < ste.length; i++) {
            if (ste[i] <= work[work.length - 1]){
                temp = Math.max(temp,(ste[i] - ste[i-1])/2);
            }else {
                temp = Math.max(temp,work[work.length - 1] - ste[i - 1]);
                break;
            }
        }
        if (ste[ste.length - 1] < work[work.length - 1]) temp = Math.max(temp,work[work.length - 1] - ste[ste.length - 1]);
        return temp;
    }
}
