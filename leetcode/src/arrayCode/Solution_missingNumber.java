package arrayCode;

public class Solution_missingNumber {
    public static void main(String[] args) {
        int[] arr = {0,1,3};
        System.out.println(missingNumber(arr));
    }
    static int missingNumber(int[] nums) {
        int num = 0;
        int len = nums.length-1;
        if(nums.length <= 2){
            if(nums.length == 1){
                if(nums[0] % 2 == 0){
                    num = nums[0] + 1;
                }else {
                    num = nums[0] - 1;
                }
            }else {

            }
        }else{
            boolean flag = true;
            while(flag){
                for (int i = 0; i < nums.length/2; i++) {
                    if(nums[i+1]-nums[i]>1){
                        num = nums[i+1]-1;
                        flag = false;
                        break;
                    }
                    if(nums[len]-nums[len-1]>1){
                        num = nums[len]-1;
                        flag = false;
                        break;
                    }
                    len--;
                }
            }
        }
        return num;
    }
}
