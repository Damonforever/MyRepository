package arrayCode;

public class Solution_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {


        if(nums.length>0){
            int[] arr = new int[nums.length-k+1];
            int count = 0;
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if(k > 1){
                    if(i>= k-1){
                        if(nums[i]>max){
                            max = nums[i];
                        }
                        arr[count] = max;
                        count++;
                    }else {
                        if(nums[i]>max){
                            max = nums[i];
                        }
                    }
                }else {
                    arr[count] = nums[i];
                    count++;
                }
            }
            return arr;
        }else {
            int[] arr = new int[0];
            return arr;
        }

    }
}
