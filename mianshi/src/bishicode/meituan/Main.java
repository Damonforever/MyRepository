package bishicode.meituan;

import java.util.*;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/22 10:05
 */
public class Main {
    static boolean[] flags;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        String[] strings = input.split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        List<List<Integer>> result = my(nums);
        int count = result.size();
        result.sort((o1, o2) -> {
            for (int i = 0; i < n; i++) {
                if (o1.get(i) > o2.get(i)){
                    return 1;
                }else if (o1.get(i) < o2.get(i)){
                    return -1;
                }

            }
            return o1.get(0) - o2.get(0);
        });
        System.out.println(count);
        for (List<Integer> list : result) {
            for (int i = 0; i < n; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
    static List<List<Integer>> my(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        flags = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,ans,0,perm);
        return ans;
    }
    static void backtrack(int[] nums,List<List<Integer>> ans,int index,List<Integer> perm){
        if (index == nums.length){
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flags[i] || (i > 0 && nums[i] == nums[i-1] && !flags[i-1])){
                continue;
            }
            perm.add(nums[i]);
            flags[i] = true;
            backtrack(nums,ans,index+1,perm);
            flags[i] = false;
            perm.remove(index);
        }
    }
}
