package BinarySearchCode;

/**
 * @description: 在 D 天内送达包裹的能力
 * @author: Damon
 * @date 2021/8/19 10:38
 */
public class Solution_shipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int left = getMinWeight(weights), right = getMaxWeight(weights);
        while (left < right){
            int middle = left + (right - left)/2;
            if (canTransport(weights,middle,days)){
                right = middle;
            }else {
                left = middle + 1;
            }
        }
        return left;
    }
    boolean canTransport(int[] weights, int capacity, int days){
        int time = 0;
        int len = weights.length;
        for (int i = 0; i < len; i++) {
            int cap = capacity;
            while (i < len && cap >= weights[i]){
                cap -= weights[i];
                i++;
            }
            time++;
            if (i < len) i--;
        }
        return time <= days;
    }
    int getMaxWeight(int[] weights){
        int count = 0;
        for (int weight : weights) {
            count += weight;
        }
        return count;
    }
    int getMinWeight(int[] weights){
        int count = 0;
        for (int weight : weights) {
            count = Math.max(count,weight);
        }
        return count;
    }
}
