package arrayCode;
/*
* 找出数组中重复的数字。
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
示例 1：
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3
限制：
2 <= n <= 100000
* */

import java.util.Arrays;

public class Solution_findRepeatNumber {

    public static void main(String[] args) {
        int[] array1 = {2,3,1,0,2,5,3};
        int numbers = findRepeatNumber(array1);
        System.out.println(numbers);
    }

    static int findRepeatNumber(int[] nums){

        Arrays.sort(nums);
        int len=nums.length-1;
        int num=0;
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if(flag && i!=len){
                if(flag && nums[i]-nums[i+1]==0){
                    num=nums[i];
                    flag = false;
                }
                if(flag && nums[len]-nums[len-1]==0){
                    num = nums[len];
                    len--;
                    flag = false;
                }
            }else {
                break;
            }

        }
        return num;

    }
}

