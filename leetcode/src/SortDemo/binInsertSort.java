package SortDemo;

public class binInsertSort {
    public static int[] binInsertSort(int[] arr){
        int low, high, mid;
        int temp;
        //从第二个开始排序
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            low = 0;
            high = i - 1;
            while (low <= high){
                mid = (low + high)/2;
                if(temp < arr[mid]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }
            //找到插入位置后,需要将a[low...i-1]后移一位
            for (int j = i; j > low; j--){
                arr[j] = arr[j--];
            }
            //插入low
            arr[low] = temp;
        }
        return arr;
    }
}
