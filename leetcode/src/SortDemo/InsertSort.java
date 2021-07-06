package SortDemo;

public class InsertSort {
    public static int[] insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //缓存需要排序的元素
            int temp = arr[i];
            //从右向左在有序区间a[0...i-1]中找a[i]的插入位置
            int j = i - 1;
            //将大于temp的数据后移
            while(j >= 0 && temp < arr[j]){
                arr[j+1] = arr[j--];
            }
            //在j+1处插入数据
            arr[j+1] = temp;
        }
        return arr;
    }
}
