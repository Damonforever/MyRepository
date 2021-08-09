package arrayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: N数之和
 * @author: Damon
 * @date 2021/8/9 16:10
 */
public class Solution_NSum {
    //N数之和最终模板，调用本函数之前记得要先将数组排序
    //n表示是几个数之和
    List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target){
        int sz = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (n < 2 || sz < n) return result;
        //2Sum是base case
        if (n == 2){
            int low = start, high = sz - 1;
            while (low < high){
                int sum = nums[low] + nums[high];
                int left = nums[low], right = nums[high];
                if (sum < target){
                    while (low < high && nums[low] == left) low++;
                }else if (sum > target) {
                    while (low < high && nums[high] == right) high--;
                }else {
                    List<Integer> res = new ArrayList<>();
                    res.add(left);
                    res.add(right);
                    result.add(res);
                    while (low < high && nums[low] == left) low++;
                    while (low < high && nums[high] == right) high--;
                }
            }
        }else {
            //n > 2需要递归计算 (n-1)Sum的结果
            for (int i = start; i < sz; i++) {
                List<List<Integer>> subs = nSumTarget(nums,n-1, i + 1, target - nums[i]);
                for (List<Integer> sub : subs) {
                    sub.add(nums[i]);
                    subs.add(sub);
                }
                while (i < sz - 1 && nums[i + 1] == nums[i]) i++;
            }
        }
        return result;
    }
}
