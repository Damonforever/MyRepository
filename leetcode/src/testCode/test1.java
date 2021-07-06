package testCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test1 {
    public static void main(String[] args) {
//        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
//        ArrayList<Integer> result = new ArrayList<>();
//        ArrayList<Integer> result1 = new ArrayList<>();
//        result.add(1);
//        result.add(2);
//        result.add(3);
//        results.add(result);
//        result1.add(4);
//        result1.add(5);
//        results.add(result1);
//        int[][] array = new int[results.size()][];
//        for (int i = 0; i < results.size(); i++) {
//            ArrayList<Integer> arr = results.get(i);
//            int [] get = new int [arr.size()];
//            for (int j = 0; j < arr.size(); j++) {
//                get[j] = arr.get(j);
//            }
//            array[i] = get;
//        }
//        List<Integer> list = (List<Integer>) Stream.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(8, 9, 10, 11, 12))
//                .flatMap(Collection::stream).collect(Collectors.toList());
//
//        for (int i = 0, length = list.size(); i < length; i++) {
//            System.out.println(list.get(i));
//        }
//        String[] testStrings = { "java", "react", "angular", "javascript", "vue" };
//
//        Optional<String> max = Stream.of(testStrings).max(Comparator.comparingInt(String::length));
//
//        System.out.println(max);
//        int sum = Stream.of(5, 6, 7, 8).reduce(0, Integer::sum);
//        for (int i = 1; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                for (int k = 0; k < 10; k++) {
//                    for (int l = 1; l < 10; l++) {
//                        if((1000*l+100*k+10*j+i) % (1000*i+100*j+10*k+l) == 0){
//                            System.out.println(1000*i+100*j+10*k+l);
//                        }
//
//                    }
//                }
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 250; i++) {
//            sb.append(i);
//        }
//        System.out.println(sb.substring(238,246));
//        int x = 99;
//        for (x > 50 && x <2000){
//            x++;
//        }
        System.out.println(tib(37));;

    }
    static int tib(int n){
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int p = 0, q = 1, s = 1, count = 2;
        while (count < n){
            count++;
            s +=(p + q);
            q = s - (p + q);
            p = s - q - p;
        }
        return s;
    }
//     static int fib(int num){
//        if (num == 0) return 0;
//        if (num == 1) return 1;
//        int p = 0;
//        int q = 1;
//        int count = 1;
//        while (count < num){
//            count++;
//            q = p + q;
//            p = q - p;
//        }
//        return q;
//    }
}
