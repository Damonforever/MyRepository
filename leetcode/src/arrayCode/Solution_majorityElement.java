package arrayCode;

import java.util.HashMap;
import java.util.Map;

public class Solution_majorityElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(nums));
    }
    static int majorityElement(int[] nums) {
//        Map<Integer,Integer> map = new HashMap<>();
//        int count = 0;
//        int value = 0;
//        int ch = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(map.containsKey(nums[i])){
//                count = map.get(nums[i])+1;
//                map.put(nums[i],count);
//            }else {
//                map.put(nums[i],1);
//            }
//        }
//        count = 0;
//        for (Integer key : map.keySet()) {
//            value = map.get(key);
//            if (count < value){
//                count = value;
//                ch = key;
//            }
//        }
//        return ch;
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
