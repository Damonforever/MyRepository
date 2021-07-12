package bitOperationCode;

public class Solution_add {
    public static void main(String[] args) {
        System.out.println(add(-2,3));
    }
    public static int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
}
