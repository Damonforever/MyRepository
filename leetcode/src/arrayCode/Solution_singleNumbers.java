package arrayCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @description: 剑指offer56，数组中数字出现的次数,位操作真的吊
 * @author: Damon
 * @date 2021/6/30 14:48
 */
public class Solution_singleNumbers {
    public static void main(String[] args) {
        int[] a = {1,2,10,4,1,4,3,3};
        int[] arr = singleNumbers(a);
        System.out.println();
    }
    public static int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};

//        for (int i : nums){
//            if(set.add(i)){
//
//            }else {
//                set.remove(i);
//            }
//        }
//        int[] arr = new int[2];
//        return set.stream().mapToInt(Integer::intValue).toArray();




//        int[] arr = Arrays.stream(nums).filter(set::add).toArray();
//        return arr;
    }
}
