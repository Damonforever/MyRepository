package bishicode.xiecheng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/9 19:42
 */
public class Main1 {
    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String string = sc.nextLine();
        int count  = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[][] nums = new int[m][2];
        int min = 0,max = 0;
        while (count < m){
            int l = sc.nextInt();
            int k = sc.nextInt();
            nums[count][0] = l;
            nums[count][1] = k;
            sc.nextLine();
            if (count ==0 ){
                min = l;
                max = l;
            }else {
                min = Math.min(min,l);
                max = Math.max(max,l);
            }
            count++;
        }
        ArrayList<Integer> list= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int index = i;
            while( i < n && string.charAt(i) != '0' ){
                i++;
            }
            list.add(i - index);
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int len = list.get(i);
            if (map.containsKey(len)){
                sum += map.get(len);
                continue;
            }
            if (len >= min){
                res = 0;
                backtrack(nums,len,min,0);
                sum += res;
            }
        }
        System.out.println(sum);
    }
    static void backtrack(int[][] nums, int len, int min,int sum){
        if (len < min){
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (len >= min){
                if (len - nums[i][0]>= 0){
                    len = len - nums[i][0];
                    sum += nums[i][1];
                    res = Math.max(res,sum);
                    backtrack(nums, len,min,sum);
                    sum -= nums[i][1];
                    len = len + nums[i][0];
                }
            }
        }
    }
}
