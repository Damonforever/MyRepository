package SortDemo;

public class QuickSort {
    public static void qucikSort(int[] arr, int low, int high){
        if(low < high){
            int index = getIndex(arr,low,high);
            //左半部分调
            qucikSort(arr,low,index-1);
            //右半部分调
            qucikSort(arr,index + 1, high);
        }
    }
    public static int getIndex(int[] arr, int low, int high){
        //获取基准数据
        int temp = arr[low];
        while(low < high){
            //先移动右侧指针，只要队尾元素大于基准数据，向前移动high指针
            while(low < high && arr[high] >= temp){
                high--;
            }
            //将high赋值给low
            arr[low] = arr[high];
            //移动左侧指针，只要队首元素小于基准数据，向后移动
            while (low < high && arr[low] <= temp){
                low++;
            }
            //将low赋值给high
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }
}
