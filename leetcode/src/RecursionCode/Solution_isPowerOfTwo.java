package RecursionCode;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/4 16:19
 */
public class Solution_isPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
    }
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if(n != 1 && n % 2 == 1){
            return false;
        }else {
            String str = Integer.toBinaryString(n);
            int num = (int) Math.pow(2,str.length() - 1);
            return n <= num;
        }
    }
}
