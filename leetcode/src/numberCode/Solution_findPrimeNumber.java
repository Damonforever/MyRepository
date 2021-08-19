package numberCode;

import java.util.Arrays;

/**
 * @description: 高效查找素数
 * @author: Damon
 * @date 2021/8/18 21:27
 */
/*
* 返回[2,n)之间的素数个数
* */
public class Solution_findPrimeNumber {

    //最笨方法   O(n^2)
    int countPrime(int n){
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(n)) count++;
        }
        return count;
    }
    boolean isPrime(int number){
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
    //优化 O(n*sqrt(n))
    int countPrime1(int n){
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(n)) count++;
        }
        return count;
    }
    boolean isPrime1(int number){
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    //高效实现 第一版，还可继续优化
    int countPrime2(int n){
        boolean[] isPrime = new boolean[n];
        //初始化为true
        Arrays.fill(isPrime,true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]){
                for (int j = 2 * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
    //最终版
    int countPrime3(int n){
        boolean[] isPrime = new boolean[n];
        //初始化为true
        Arrays.fill(isPrime,true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]){
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}
