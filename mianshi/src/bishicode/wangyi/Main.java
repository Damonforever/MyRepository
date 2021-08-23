package bishicode.wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/21 16:28
 */
public class Main {
    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] arr = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
        int M = scanner.nextInt();
        m1(arr,0,new ArrayList<>(),M);
        System.out.println(count);

    }

    public static void m1(Integer[] arr, int pos, List<Integer> tmp,int M){
        if (tmp.size() == 2){
            if (tmp.get(0) + tmp.get(1) < M){
                count++;
            }
            return;
        }
        while (pos < arr.length){
            tmp.add(arr[pos]);
            m1(arr,pos+1,tmp,M);
            tmp.remove(arr[pos]);
            pos++;
        }
    }
}
