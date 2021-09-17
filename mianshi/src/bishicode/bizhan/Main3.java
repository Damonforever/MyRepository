package bishicode.bizhan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/13 19:22
 */
public class Main3 {
    public static void main(String[] args) {
        System.out.println(GetLeastNumbers(new int[]{3,4,1,2},4));
    }
    public static int[] GetLeastNumbers(int[] input, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < input.length; i++) {
            queue.add(input[i]);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
    public static int[] GetSortedTasks(int[][] taskLists) {
        int m = taskLists.length;
        int n = taskLists[0].length;
        int[] res = new int[m*n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[count] = taskLists[i][j];
                count++;
            }
        }
        Arrays.sort(res);
        return res;
    }
}
