package dpCode;

/**
 * @description: 使用最小花费爬楼梯
 * @author: Damon
 * @date 2021/7/5 21:01
 */
public class Solution_minCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
    }
    public static int minCostClimbingStairs(int[] cost) {
        int fist = cost[0];
        int second = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int temp = second;
            second = fist < second ? fist + cost[i] : second + cost[i];
            fist = temp;
        }
        return Math.min(fist, second);
    }
}
