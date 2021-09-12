package bishicode.weizhong;

import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/10 19:02
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int k = Integer.parseInt(strings[0]);
        StringBuilder m = new StringBuilder(strings[1]).reverse();
        StringBuilder n = new StringBuilder(strings[2]).reverse();
        int len = Math.min(m.length(), n.length());
        StringBuilder sb = new StringBuilder();
        int jinwei = 0;
        int count = 0;
        while (count < len){
            int m1 = Integer.parseInt(m.charAt(count) + "");
            int n1 = Integer.parseInt(n.charAt(count) + "");
            int sum = m1 + n1 + jinwei;
            if (sum >= k){
                sum %= k;
                jinwei = 1;
            }else {
                jinwei = 0;
            }
            sb.append(sum);
            count++;
        }
        if (jinwei != 0){
            len = Math.max(m.length(), n.length());
            if (m.length() > n.length()){
                while (count < len){
                    int m1 = Integer.parseInt(m.charAt(count) + "");
                    int sum = m1 + jinwei;
                    if (sum >= k){
                        sum %= k;
                        jinwei = 1;
                    }else {
                        jinwei = 0;
                    }
                    sb.append(sum);
                    count++;
                }
                if (jinwei != 0) sb.append(1);
            }else if (m.length() < n.length()){
                while (count < len){
                    int n1 = Integer.parseInt(n.charAt(count) + "");
                    int sum = n1 + jinwei;
                    if (sum >= k){
                        sum %= k;
                        jinwei = 1;
                    }else {
                        jinwei = 0;
                    }
                    sb.append(sum);
                    count++;
                }
                if (jinwei != 0) sb.append(1);
            }else {
                sb.append(1);
            }
        }else {
            if (m.length() > n.length()){
                sb.append(m.substring(count));
            }else if(m.length() < n.length()) {
                sb.append(n.substring(count));
            }
        }
        System.out.println(sb.reverse().toString());

    }
    static void sort(int[] arr, int begin, int end){
        if (begin < end){
            int temp = arr[begin];
            int i = begin;
            int j = end;
            while (i<j){
                while (i<j && arr[j] > temp){
                    j--;
                }
                arr[i] = arr[j];
                while (i<j && arr[i] <= temp){
                    i++;
                }
                arr[j] = arr[i];
            }
            arr[i] = temp;
            sort(arr,begin,i-1);
            sort(arr,i+ 1,end);
        }else {
            return;
        }
    }
}
//class Person{
//    private String[] name;
//    public String getName(){
//        return this.name[0] + " " + this.name[1];
//    }
//
//    public void setName(String[] name) {
//        this.name = name;
//    }
//}