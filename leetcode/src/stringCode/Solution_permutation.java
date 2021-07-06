package stringCode;

import java.util.HashSet;
import java.util.Set;

public class Solution_permutation {

    public static void main(String[] args) {
        String[] str = permutation("abc");
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
    static String[] permutation(String s) {
        Set<String> allSorts = new HashSet<>();
        char[] array = s.toCharArray();
        getSort(array,0,s.length()-1,allSorts);
        String[] strings = new String[allSorts.size()];
        int count = 0;
        for(String str:allSorts){
            strings[count] = str;
            count++;
        }

        return strings;
    }
    static void getSort(char[] nums, int start, int end,Set<String> allSorts) {
        if (start == end) { // 当只要求对数组中一个数字进行全排列时，只要就按该数组输出即可
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<=end; i++) {
                sb.append(nums[i]);
            }
            allSorts.add(sb.toString()); // 将新的排列组合存放起来
        } else {
            for (int i=start; i<=end; i++) {
                char temp = nums[start]; // 交换数组第一个元素与后续的元素
                nums[start] = nums[i];
                nums[i] = temp;
                getSort(nums, start + 1, end,allSorts); // 后续元素递归全排列
                nums[i] = nums[start]; // 将交换后的数组还原
                nums[start] = temp;
            }
        }
    }
}
