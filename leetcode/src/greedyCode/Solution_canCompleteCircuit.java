package greedyCode;

/**
 * @description: 加油站
 * @author: Damon
 * @date: 2021/8/7 20:45
 */
public class Solution_canCompleteCircuit {
    public static void main(String[] args) {
        System.out.println(new Solution_canCompleteCircuit().canCompleteCircuit(new int[]{3,3,4},new int[]{3,4,4}));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int count;
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            count = gas[i] - cost[i];
            for (int j = i + 1; j < len; j++) {
                if (count >= 0) count += (gas[j] - cost[j]);
                else break;
            }
            if (count >= 0) {
                for (int j = 0; j < i; j++) {
                    if (count >= 0) count += (gas[j] - cost[j]);
                    else break;
                }
                if (count >= 0) return i;
            }
        }
        return -1;
    }
}
