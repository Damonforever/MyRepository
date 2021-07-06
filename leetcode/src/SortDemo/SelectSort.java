package SortDemo;

/**
 * @author: Damon
 * @description: 选择排序
 * @date 2021/6/28 21:00
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] a = {3,8,9,4,5,6,7,1,2};
        int[] arr = selectSort(a);
        for (int j : arr) {
            System.out.println(j);
        }

    }
    static int[] selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int flag = i;
            for (int j = i; j < arr.length; j++){
                if(arr[flag] > arr[j]) flag = j;
            }
            if(i != flag){
                int temp = arr[i];
                arr[i] = arr[flag];
                arr[flag] = temp;
            }
        }
        return arr;
    }
}
