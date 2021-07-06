package bitOperationCode;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/1 15:53
 */
public class Solution_div {
    public static int div(int a,int b){
        if (a == 0 || b == 0)
            return 0;//b不能为0，如果b是0我们应该抛异常的，这里简单处理就没抛
        int x = a < 0 ? negative(a) : a;
        int y = b < 0 ? negative(b) : b;
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((x >> i) >= y) {
                result = add(result, 1 << i);
                x = subtraction(x, y << i);
            }
        }
        return (a ^ b) >= 0 ? result : -result;
    }
    //负数转化为正数
    private static int negative(int a){
        return add(~a,1);
    }
    public static int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
    public static int subtraction(int a,int b){
        while (b != 0){
            int c = a & b;
            a ^= c;
            b ^= c;
            a |= b;
            b <<= 1;
        }
        return a;
    }
}
