package bishicode.qita;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/25 16:49
 */
public class Test360 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int[] temp = Arrays.copyOf(nums, nums.length);
            int[] tmp = Arrays.copyOf(nums, nums.length);
            if (i == 0){
                int k = i + 1;
                while(k < n){
                    //降序
                    int m = temp[k] - temp[k - 1];
                    if (m >= 0){
                        int val = m + 1;
                        temp[k] = temp[k] - val;
                        count += val;
                    }
                    k++;
                }
                min = Math.min(min,count);
                //升序
                k = i + 1;
                count=0;
                while ( k < n){
                    int m = tmp[k] - tmp[k-1];
                    if (m <= 0){
                        int val = m - 1;
                        temp[k] = tmp[k] - val;
                        count -= val;
                    }
                    k++;
                }
                min = Math.min(min,count);

            }else if (i == n -1){
                int k = i -1;
                while (k >= 0){
                    //降序

                }
            }
        }
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            int count = 1;
//            if (i == 0){
//                int k = i + 1;
//                while (k < n && nums[k] < nums[k-1]) {
//                    count++;
//                    k++;
//                }
//                max = Math.max(max,count);
//            }else if (i == n -1){
//                int k = i - 1;
//                while (k >= 0 && nums[k+ 1] > nums[k]){
//                    count++;
//                    k--;
//                }
//                max = Math.max(max,count);
//            }else {
//                int l = i -1;
//                int r = i + 1;
//                while (l >= 0 && nums[l + 1] > nums[l]){
//                    count++;
//                    l--;
//                }
//                while (r < n && nums[r] < nums[r-1]){
//                    count++;
//                    r++;
//                }
//                max = Math.max(count,max);
//            }
//        }
//        System.out.println(max);
    }
}
