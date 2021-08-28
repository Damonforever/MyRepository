package test;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/26 19:12
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxValues("1321",3));
    }
    public static int maxValues(String s, int k){
        int maxValue = 0;
        int len = s.length();
        for (int i = 0; i <= len - k; i++) {
            maxValue = Math.max(maxValue,Integer.parseInt(s.substring(i,i+k)));
        }
        return maxValue;
    }

}
