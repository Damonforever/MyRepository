package arrayCode;

import java.util.*;

/**
 * @description: 三数之和
 * @author: Damon
 * @date 2021/7/29 10:29
 */
public class Solution_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSumTarget(nums,0);
    }
    List<List<Integer>> threeSumTarget(int[] nums, int target){
        //先排序
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        //穷举threeSum的第一个数
        for (int i = 0; i < n; i++) {
            List<List<Integer>> tuples = twoSumTarget(nums,i + 1,target - nums[i]);
            //存在满足条件的二元组
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                result.add(tuple);
            }
            while (i < n - 1 && nums[i+1] == nums[i]) i++;
        }
        return result;
    }
    //有序数组两数之和框架
    List<List<Integer>> twoSumTarget(int[] nums, int start, int target){
        int low = start, high = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while (low < high){
            int sum = nums[low] + nums[high];
            int left = nums[low], right = nums[high];
            if (sum < target){
                while (low < high && nums[low] == left) low++;
            }else if (sum > target){
                while (low < high && nums[high] == right) high--;
            }else {
                ArrayList<Integer> res = new ArrayList<>();
                res.add(left);
                res.add(right);
                result.add(res);
                while (low < high && nums[low] == left) low++;
                while (low < high && nums[high] == right) high--;
            }
        }
        return result;
    }
}
