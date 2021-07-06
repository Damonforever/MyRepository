package numberCode;

import java.util.Arrays;

/**
 * @description: 把数组排成最小的数
 * @author: Damon
 * @date 2021/7/2 10:00
 */
public class Solution_minNumber {
    public static void main(String[] args) {
        int[] arr = {3,30,34,5,9};
        System.out.println(minNumber(arr));
    }
    static String minNumber(int[] nums) {
        String[] strings = Arrays.stream(Arrays.stream(nums).mapToObj(String::valueOf).toArray()).toArray(String[]::new);
        quickSort(strings,0,strings.length - 1);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(strings).forEach(sb::append);
        return sb.toString();
    }
     static void quickSort(String[] strings, int low, int high){
        if (low < high){
            int index = getIndex(strings,low,high);
            quickSort(strings,low,index - 1);
            quickSort(strings, index + 1, high);
        }

    }
    static int getIndex(String[] strings, int low, int high){
        String s = strings[low];
        while (low < high){
            while (low < high && (strings[high] + s).compareTo(s + strings[high]) >= 0){
                high--;
            }
            strings[low] = strings[high];
            while (low < high && (strings[low] + s).compareTo(s + strings[low]) <= 0){
                low++;
            }
            strings[high] = strings[low];
        }
        strings[low] = s;
        return low;
    }
}
