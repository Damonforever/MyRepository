package bitOperationCode;

/**
 * @description: 乘法
 * @author: Damon
 * @date 2021/7/1 15:25
 */
public class Solution_mult {
    public static void main(String[] args) {
        System.out.println(mult(13,9));
    }
    public static int mult(int a,int b){
        int x = a > 0 ? a : negative(a);
        int y = b > 0 ? b : negative(b);
        int res = 0;
        while (y != 0){
            if ((y & 1) == 1) res = add3(res,x);
            x <<= 1;
            y >>= 1;
        }
        return (a ^ b) > 0 ? res : negative(res);
    }
    //负数转化为正数
    private static int negative(int a){
        return add3(~a,1);
    }
    //相加
    private static int add3(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}
