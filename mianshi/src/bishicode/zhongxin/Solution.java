package bishicode.zhongxin;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/24 10:36
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(pairNumbers(new int[]{1,2,2,3,5},new int[]{3,1,5,2,4}));
        System.out.println(m1(45323584));
    }
    public static int pairNumbers(int[] a, int[] b){
        int count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i+ 1; j < a.length; j++) {
                int r1 = a[i] - a[j];
                int r2 = b[i] - b[j];
                if (r1 > r2){
                    count++;
                }
            }
        }
        return count;
    }
    public static int m1(long n) {
        String s = "" + n;
        int length = s.length() / 2;
        if (length == 0) {
            return 0;
        }
        int count = 0;
        long digitMax = (long) (Math.pow(10, length) - 1);
        count += digitMax;
        if (s.length() % 2 == 0) {
            long tmp = Long.parseLong(s.substring(0, length));
            boolean add = Long.parseLong(s.substring(0, length)) > Long.parseLong(s.substring(length));
            count -= ((long) Math.pow(10, length) - 1 - tmp);
            if (add) {
                count -= 1;
            }
        }
        return count;
    }
}
