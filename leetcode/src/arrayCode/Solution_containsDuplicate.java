package arrayCode;

import java.util.HashSet;

public class Solution_containsDuplicate {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,1};
        System.out.println(containsDuplicate(num));
    }
    static boolean containsDuplicate(int[] nums) {
        boolean flag= false;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
