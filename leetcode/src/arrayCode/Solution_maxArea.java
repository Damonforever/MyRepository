package arrayCode;

/**
 * @description: 盛水最多的容器
 * @author: Damon
 * @date 2021/7/28 21:05
 */
public class Solution_maxArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public static int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int maxValue = Math.min(height[left],height[right])*(right-left);
        int min = Math.min(height[left],height[right]);
        while(left < right){
            if (height[left] < height[right]){
                while (left < right && height[left] <= min) {
                    left++;
                }
                maxValue = Math.max(Math.min(height[left],height[right])*(right - left),maxValue);
                min = Math.min(height[left],height[right]);
            }else {
                while (left < right && height[right] <= min){
                    right--;
                }
                maxValue = Math.max(Math.min(height[left],height[right])*(right - left),maxValue);
                min = Math.min(height[left],height[right]);
            }
        }
        return maxValue;
        //暴力解法
//        int max = 0;
//        int len = height.length;
//        for (int i = 0; i < len; i++) {
//            if (height[i] == 0) continue;
//            for (int j = i + 1; j < len; j++) {
//                max = Math.max(max,(j-i)*Math.min(height[i],height[j]));
//            }
//        }
//        return max;
    }
}
