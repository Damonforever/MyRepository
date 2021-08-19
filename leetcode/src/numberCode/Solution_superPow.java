package numberCode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description: 超级次方
 * @author: Damon
 * @date 2021/8/18 21:47
 */
/*
* 要求你的算法返回幂运算 a^b 的计算结果与 1337 取模（mod，也就是余数）后的结果。就是你先得计算幂 a^b，但是这个 b 会非常大，所以 b 是用数组的形式表示的。
* 这道题可以有三个难点：
* 一是如何处理用数组表示的指数，现在 b 是一个数组，也就是说 b 可以非常大，没办法直接转成整型，否则可能溢出
* 二是如何得到求模之后的结果？按道理，起码应该先把幂运算结果算出来，然后做 % 1337 这个运算。
* 但问题是，指数运算真实结果肯定会大得吓人，也就是说，算出来真实结果也没办法表示，早都溢出报错了。
* 三是如何高效进行幂运算，进行幂运算也是有算法技巧的
* */
public class Solution_superPow {
    private int base = 1337;
    //方便计算需要用将数组转换为栈之后用辅助函数计算
    int superPow(int a, int[] b){
        Stack<Integer> stack = new Stack<>();
        Arrays.stream(b).forEach(stack::push);
        return helper(a,stack);
    }
    int helper(int a,Stack<Integer> stack){
        if (stack.isEmpty()) return 1;
        int last = stack.pop();
        int part1 = myPow(a,last);
        int part2 = myPow(helper(a,stack),10);
        return (part1 * part2) % base;
    }
    int myPow(int a,int k){
        a %= base;
        int res = 1;
        for (int i = 0; i < k; i++) {
            res *= a;
            res %= base;
        }
        return res;
    }

}
