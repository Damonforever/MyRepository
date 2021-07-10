package dpCode;

/**
 * @description: 最佳观光组合
 * @author: Damon
 * @date 2021/7/10 10:16
 */
public class Solution_maxScoreSightseeingPair {
    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
    }
    public static int maxScoreSightseeingPair(int[] values) {
        int ans = 0, mx = values[0] + 0;
        for (int j = 1; j < values.length; ++j) {
            ans = Math.max(ans, mx + values[j] - j);
            // 边遍历边维护
            mx = Math.max(mx, values[j] + j);
        }
        return ans;
        //暴力解法
//        for (int i = 0; i < values.length; i++) {
//            for (int j = i+1; j < values.length; j++) {
//                temp = values[j] + values[i] - (j - i);
//                max = Math.max(max,temp);
//            }
//        }
    }
}
