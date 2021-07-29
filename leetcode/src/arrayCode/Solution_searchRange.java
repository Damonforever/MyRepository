package arrayCode;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/27 19:24
 */
public class Solution_searchRange {
//    public static void main(String[] args) {
//        System.out.println(searchRange(new int[]{5,7,7,8,8,10},8));
//    }
    public static int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
        //O(n)
//        int count =0;
//        int[] point ={-1,-1};
//        int s=-1;
//        int e = -1;
//        boolean flag = true;
//        if(nums.length==0){
//            return point;
//        }else{
//            for (int i = 0; i < nums.length; i++) {
//                if(nums[i]==target){
//                    count++;
//                    if(flag){
//                        s=i;
//                        flag=false;
//                    }
//                }else{
//                    if(!flag){
//                        e=s+count-1;
//                        point[0]=s;
//                        point[1]=e;
//                        break;
//                    }
//                }
//            }
//            if(!flag && e==-1){
//                e=s+count-1;
//                point[0]=s;
//                point[1]=e;
//            }
//
//        }
//        return point;
    }
    //O(log n)
    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
