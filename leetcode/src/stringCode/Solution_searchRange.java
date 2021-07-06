package stringCode;

public class Solution_searchRange {
    public static void main(String[] args) {

    }
    static int[] searchRange(int[] nums,int target){
        int count =0;
        int[] point ={-1,-1};
        int s=-1;
        int e = -1;
        boolean flag = true;
        if(nums.length==0){
            return point;
        }else{
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]==target){
                    count++;
                    if(flag){
                        s=i;
                        flag=false;
                    }
                }else{
                    if(!flag){
                        e=s+count-1;
                        point[0]=s;
                        point[1]=e;
                        break;
                    }
                }
            }
            if(!flag && e==-1){
                e=s+count-1;
                point[0]=s;
                point[1]=e;
            }

        }
        return point;

    }
}
