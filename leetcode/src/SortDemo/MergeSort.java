package SortDemo;

/**
 * @description: 归并排序
 * @author: Damon
 * @date 2021/6/30 10:09
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {30,24,85,16,36,53,91,47};
        int[] a = mergeSort(arr,0,arr.length - 1);
        for (int j : a) {
            System.out.println(j);
        }
    }
    public static int[] mergeSort(int[] arr, int left, int right){
        if(left < right){
            int middle = (right + left)/2;
            mergeSort(arr,left,middle);
            mergeSort(arr,middle+1,right);
            merge(arr,left,right,middle);
        }
        return arr;
    }
    private static void merge(int[] arr, int left, int right, int middle){
        int[] temarray =  new int[arr.length];
        int rightIndex = middle + 1;
        int leftIndex = left;
        int temIndex = left;
        while (left <= middle && rightIndex <= right){
            if(arr[left] <= arr[rightIndex]){
                temarray[temIndex++] = arr[left++];
            }else {
                temarray[temIndex++] = arr[rightIndex++];
            }
        }
        while (left <= middle){
            temarray[temIndex++] = arr[left++];
        }
        while (rightIndex <= right){
            temarray[temIndex++] = arr[rightIndex++];
        }
        while (leftIndex <= right){
            arr[leftIndex] = temarray[leftIndex++];
        }
    }
}
