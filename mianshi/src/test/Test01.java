package test;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/15 19:07
 */
public class Test01 {
    public static void main(String[] args) {
        int num = 1;
        while (num < 2021){
            num ^= (num + 1);
            num++;
        }
        System.out.println(num);
    }
}
