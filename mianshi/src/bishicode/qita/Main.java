package bishicode.qita;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/16 19:16
 */
public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        sc.nextLine();
//        int[][] nums = new int[n][m];
//        int[][] flag = new int[n][m];
//        int[][] dp = new int[n][m];
//        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                nums[i][j] = sc.nextInt();
//                if (map.containsKey(nums[i][j])){
//                    ArrayList<Integer> list = new ArrayList<>(map.get(nums[i][j]));
//                    list.add(i);
//                    list.add(j);
//                    map.put(nums[i][j],list);
//                }else {
//                    ArrayList<Integer> list = new ArrayList<>();
//                    list.add(i);
//                    list.add(j);
//                    map.put(nums[i][j],list);
//                }
//            }
//            sc.nextLine();
//        }
//        if (nums[0][0] == nums[n-1][m-1]) {
//            System.out.println(0);
//            return;
//        }


    }
    static ArrayList<Double> helpers(double[] nums){
        double[] min = new double[nums.length];
        double[] max = new double[nums.length];
        double temp = nums[0];
        ArrayList<Double> doubles = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < temp){
                min[i] = 1;
            }else {
                temp = nums[i];
            }
        }
        temp = nums[nums.length-1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > temp){
                max[i] = 1;
            }else {
                temp = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (max[i] ==1 && min[i] == 1){
                doubles.add(nums[i]);
            }
        }
        //差一个头尾判断
        return doubles;
    }
    public static int trapRainWater(int[][] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int m = heights[0].length;
        // 用一个vis数组来标记这个位置有没有被访问过
        boolean[][] vis = new boolean[n][m];
        // 优先队列中存放三元组 [x,y,h] 坐标和高度
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        // 先把最外一圈放进去
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    pq.offer(new int[]{i, j, heights[i][j]});
                    vis[i][j] = true;
                }
            }
        }
        int res = 0;
        // 方向数组，把dx和dy压缩成一维来做
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            // 看一下周围四个方向，没访问过的话能不能往里灌水
            for (int k = 0; k < 4; k++) {
                int nx = poll[0] + dirs[k];
                int ny = poll[1] + dirs[k + 1];
                // 如果位置合法且没访问过
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
                    // 如果外围这一圈中最小的比当前这个还高，那就说明能往里面灌水啊
                    if (poll[2] > heights[nx][ny]) {
                        res += poll[2] - heights[nx][ny];
                    }
                    // 如果灌水高度得是你灌水后的高度了，如果没灌水也要取高的
                    pq.offer(new int[]{nx, ny, Math.max(heights[nx][ny], poll[2])});
                    vis[nx][ny] = true;
                }
            }
        }
        return res;
    }
}
