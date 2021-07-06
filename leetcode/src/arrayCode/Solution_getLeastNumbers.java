package arrayCode;

import java.util.Arrays;

public class Solution_getLeastNumbers {

    static int[] getLeastNumbers(int[] arr, int k) {
        if(k > 0){
            int[] nums = new int[k];
            for (int i = 0; i < k; i++) {
                nums[i] = arr[i];
            }
            Arrays.sort(nums);
            for (int i = k; i < arr.length; i++) {
                if(arr[i]<nums[k-1]){
                    nums[k-1]=arr[i];
                    Arrays.sort(nums);
                }
            }
            return nums;
        }else{
            int[] nums = new int[0];
            return nums;
        }
    }
}
