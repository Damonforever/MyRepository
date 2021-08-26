package bishicode.bizhan;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/25 19:18
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        ArrayList<Integer[]> list = new ArrayList<>();
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            if (!s.equals("")){
                String[] split = s.split(",");
                Integer[] nums = new Integer[split.length];
                for (int i = 0; i < split.length; i++) {
                    nums[i] = Integer.parseInt(split[i]);
                }
                count++;
                list.add(nums);
            }else {
                int[][] ints = new int[count][];
                for (int i = 0; i < list.size(); i++) {
                    ints[i] = Arrays.stream(list.get(i)).collect(Collectors.toList()).stream().mapToInt(Integer::valueOf).toArray();
                }
                System.out.println(smallestCommonElement1(ints));
                break;
            }
        }
        sc.close();

    }
    public static int smallestCommonElement(int[][] mat) {
        if (mat.length == 0) return -1;
        // 遍历mat[0]中的每个数，判断其是否出现在剩余的数组中
        for (int i = 0; i < mat[0].length; i++) {
            boolean hasFind = true;
            for (int j = 1; j < mat.length; j++) {
                boolean flag = binarySearch(mat[j], mat[0][i]);
                if (!flag) {
                    hasFind = false;
                    break;
                };
            }
            if (hasFind)
                return mat[0][i];
        }
        return -1;
    }
    // 使用二分查找，查找数组中是否包含target
    private static boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >>> 1;
            if (nums[mid] == target)
                return true;
            else if (target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
    public static int smallestCommonElement1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] pos = new int[m];// 保存每行的可能的最小公共元素的列下标
        // 遍历第0行的n个数
        for (int i = 0; i < n; ++i) {
            boolean flag = true;// 第0行的第i个数（简：数x）是最小的公共元素
            // 遍历第1~n行，检查第0行的第i个数是否在第j行中
            for (int j = 1; j < m; ++j) {
                // 第j行的数小，那么下标pos[j]后移
                while (mat[j][pos[j]] < mat[0][i]) {
                    if (++pos[j] >= n) {// 第j行已经遍历完，都不存在数x
                        return -1;// 直接返回未找到，即-1
                    }
                }
                // 第j行的第pos[j]个数大于数x，那么数x不满足条件
                if (mat[j][pos[j]] > mat[0][i]) {
                    flag = false;// 设为不是
                    break;// 退出
                }
            }
            if (flag) {
                return mat[0][i];// 是最小公共元素，返回它
            }
        }
        return -1;// 没找到
    }
}
