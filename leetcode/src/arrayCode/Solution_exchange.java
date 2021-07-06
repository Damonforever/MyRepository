package arrayCode;

public class Solution_exchange {
    public static void main(String[] args) {
        int[] num = {2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1};
        exchange(num);
    }
    static int[] exchange(int[] nums) {
        int len = nums.length-1;
        int temp = 0;
        for (int i = 0; i <=((nums.length / 2) - 1); i++) {
            if(nums[i]%2==0){
                temp = nums[i];
                while(len>((nums.length/2)-1)){
                    if(nums[len]%2==1){
                        nums[i]=nums[len];
                        nums[len]=temp;
                        len--;
                        break;
                    }
                    len--;
                }
            }
        }
        int k = nums.length/2;
        for (int i = 0; i <=((nums.length / 2) - 1); i++) {
            if(nums[i]%2==0){
                temp = nums[i];
                while(k>i){
                    if(nums[k]%2==1){
                        nums[i]=nums[k];
                        nums[k]=temp;
                        k--;
                        break;
                    }
                    k--;
                }
            }
        }

        k = nums.length/2;
        for(int j = len; j>nums.length/2-1; j--){
            if(nums[j]%2==1){
                temp = nums[j];
                while(k<j){
                    if(nums[k]%2==0){
                        nums[j]=nums[k];
                        nums[k]=temp;
                        k++;
                        break;
                    }
                    k++;
                }
            }
        }

        return nums;
    }
}
