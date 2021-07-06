package dpCode;

import java.util.Arrays;
import java.util.List;

public class Solution_fib {
    public static void main(String[] args) {
        System.out.println(fib(47));
    }
    static int fib(int N){
        if(N == 0) {
            return 0;
        }
        if (N == 2 || N == 1){
            return 1;
        }
        Integer[] array  = new Integer[N+1];
        List<Integer> list = Arrays.asList(array);
        list.set(1,1);
        list.set(2,1);
        for (int i = 3; i <= N; i++) {
            list.set(i,list.get(i-1)+list.get(i-2));
        }
        return list.get(N);
    }
//    static int helper(List<Integer> list,int n){
//        if(n == 1 || n == 2){
//            return 1;
//        }
//        if(list.get(n) != null){
//            return list.get(n);
//        }
//        list.set(n,helper(list,n-1) + helper(list,n-2));
//        return list.get(n);
//    }
//    static int fib(int N){
//        if(N == 0) {
//            return 0;
//        }
//        Integer[] array  = new Integer[N+1];
//        List<Integer> list = Arrays.asList(array);
//        return helper(list,N);
//    }
}
