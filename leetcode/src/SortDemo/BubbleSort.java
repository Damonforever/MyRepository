package SortDemo;

/**
 * @description: 冒泡排序
 * @author: Damon
 * @date 2021/6/28 21:19
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {3,8,9,4,5,6,7,1,2};
        int[] arr = bubbleSort(a);
        for (int j : arr) {
            System.out.println(j);
        }
    }
    static int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i -1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
