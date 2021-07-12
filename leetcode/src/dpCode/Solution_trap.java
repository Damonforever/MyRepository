package dpCode;

/**
 * @description: 接雨水,三种方法
 * @author: Damon
 * @date 2021/7/12 11:07
 */
public class Solution_trap {
    public static void main(String[] args) {
        System.out.println(trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    //双指针解法，时间复杂度O(N),空间复杂度O(1)
    public static int trap2(int[] height) {
        int sum = 0;
        int len = height.length;
        if (len < 3) return 0;
        int leftMax = height[0];
        int rightMax = height[len - 1];
        int left = 0, right = len - 1;
        while (left <= right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if (leftMax < rightMax){
                sum += (leftMax - height[left]);
                left++;
            }else {
                sum += (rightMax - height[right]);
                right--;
            }
        }
        return sum;
    }
    //备忘录优化，时间复杂度O(N),空间复杂度O(N)
    public int trap1(int[] height) {
        int sum = 0;
        int len = height.length;
        if (len < 3) return 0;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        right[0] = height[len - 1];
        for (int j = 1; j < len; j++) {
            left[j] = Math.max(left[j - 1],height[j]);
        }
        for (int j = len - 2; j >= 0; j--){
            right[j] = Math.max(right[j + 1],height[j]);
        }
        for (int i = 1; i < len; i++) {
            sum += (Math.min(left[i],right[i]) - height[i]);
        }
        return sum;
    }
    //暴力解法,时间复杂度O(N^2),空间复杂度O(1)
    public int trap(int[] height) {
        int sum = 0;
        int len = height.length;
        if (len < 3) return 0;
        int left = height[0];
        int right = height[len - 1];
        for (int i = 1; i < len; i++) {
            for (int j = i; j < len; j++) {
                right = Math.max(right,height[j]);
            }
            for (int j = i; j >= 0; j--){
                left = Math.max(left,height[j]);
            }
            sum += (Math.min(left,right) - height[i]);
        }
        return sum;
    }
}
