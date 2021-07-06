package SortDemo;

public class ShellSort {
    public static int[] shellSort(int[] arr){
        int d = arr.length/2;
        int temp;
        while (d > 0){
            for (int i = d; i < arr.length; i++) {
                temp = arr[i];
                int j = i;
                while (j >= d && temp < arr[j - d]) {
                    arr[j] = arr[j - d];
                    j -= d;
                }
                arr[j] = temp;
            }
            d = d/2;
        }
        return arr;
    }
}
