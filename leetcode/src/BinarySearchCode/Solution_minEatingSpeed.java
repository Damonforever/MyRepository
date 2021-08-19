package BinarySearchCode;

/**
 * @description: 爱吃香蕉的珂珂
 * @author: Damon
 * @date 2021/8/19 9:49
 */
public class Solution_minEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        //套用搜索左侧边界的二分搜索
        int left = 1, right = getMax(piles) + 1;
        while (left < right){
            int middle = left +(right - left)/2;
            if (canFinish(piles,middle,h)){
                right = middle;
            }else {
                left = middle+1;
            }
        }
        return left;
    }
    boolean canFinish(int[] piles, int speed, int H){
        int time = 0;
        for (int pile : piles) {
            time += timeOf(pile,speed);
        }
        return time <= H;
    }
    //以速度speed，吃n个香蕉要多久
    int timeOf(int n, int speed){
        return (n / speed) + ((n % speed) > 0 ? 1 : 0);
    }
    int getMax(int[] piles){
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max,piles[i]);
        }
        return max;
    }
}
