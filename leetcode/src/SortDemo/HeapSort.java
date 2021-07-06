package SortDemo;

/**
 * @description: 堆排序
 * @author: Damon
 * @date 2021/6/28 21:50
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {30,24,85,16,36,53,91,47};
        int[] a = heapSort(arr);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    public static int[] heapSort(int[] a) {
        int arrayLength = a.length;
        //循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            //建堆
            buildMaxHeap(a, arrayLength - 1 - i);
            //交换堆顶和最后一个元素
            swap(a, 0, arrayLength - 1 - i);
        }
        return a;
    }

    public static void buildMaxHeap(int[] data, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int k = i;//k保存正在判断的节点
            //如果当前K节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                int biggerIndex = 2 * k + 1;//k节点的左子节点的索引
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    //如果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        biggerIndex++; //biggerIndex总是记录较大子节点的索引
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex]) {
                    //交换他们
                    swap(data, k, biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
