package BacktrackCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: 黄金矿工
 * @author: Damon
 * @date 2021/8/7 16:14
 */
public class Solution_getMaximumGold {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        //去掉最外环[]
        String input2 = input.substring(1,input.length()-1);
        String[] strings = input2.split("],");
        int len = strings.length;
        int[][] nums = new int[len][];
        for (int i = 0; i < len; i++) {
            if (strings[i].charAt(strings[i].length() - 1) != ']'){
                String temp = strings[i].substring(1);
                String[] split = temp.split(",");
                nums[i] = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
            }else {
                String temp = strings[i].substring(1,strings[i].length() - 1);
                String[] split = temp.split(",");
                nums[i] = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
            }
        }
        System.out.println(getMaximumGold(nums));
        //检测
        //Arrays.stream(nums).forEach(ints -> System.out.println(Arrays.toString(ints)));
    }

    static int getMaximumGold(int[][] grid) {
        //边界条件判断
        if (grid == null || grid.length == 0)
            return 0;
        //保存最大路径值
        int res = 0;
        //两个for循环，遍历每一个位置，让他们当做起点
        //查找最大路径值
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //函数dfs是以坐标(i,j)为起点，查找最大路径值
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        //返回最大路径值
        return res;
    }

    static int dfs(int[][] grid, int i, int j) {
        //边界条件的判断，x,y都不能越界，同时当前坐标的位置如果是0，表示有障碍物
        //或者遍历过了
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return 0;
        //先把当前坐标的值保存下来，最后再还原
        int temp = grid[i][j];
        //当前坐标已经访问过了，要把他标记为0，防止再次访问
        grid[i][j] = 0;
        //然后沿着当前坐标的上下左右4个方向查找
        int up = dfs(grid, i, j - 1);//往上找
        int down = dfs(grid, i, j + 1);//往下找
        int left = dfs(grid, i - 1, j);//往左找
        int right = dfs(grid, i + 1, j);//往右找
        //这里只要4个方向的最大值即可
        int max = Math.max(left, Math.max(right, Math.max(up, down)));
        //然后再把当前位置的值还原
        grid[i][j] = temp;
        //返回最大路径值
        return grid[i][j] + max;
    }
}
