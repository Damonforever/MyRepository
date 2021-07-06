package bitOperationCode;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/1 15:05
 */
public class Solution_subtraction {
    public int subtraction(int a,int b){
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
