package arrayCode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Solution_findContinuousSequence {
    public static void main(String[] args) {
        int[][] array = findContinuousSequence(9);
    }
    static int[][] findContinuousSequence(int target) {
        int count = target/2 + 1;
        Boolean flag = true;
        int end = 1;
        int sum = 0;
        int str;
        List<ArrayList<Integer>> results = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        while(end <= count){
            if(flag){
                sum += end;
                result.add(end);
            }
            if(sum == target){
                results.add(new ArrayList<>(result));
                str = result.remove(0);
                sum -= str;
                end++;
                flag = true;
            }else if(sum < target){
                end++;
                flag = true;
            }else {
                str = result.remove(0);
                sum -= str;
                flag = false;
            }
        }
        int[][] arrays = results.stream()                                // Stream<List<Integer>>
                .map(list -> list.stream().mapToInt(i -> i).toArray()) // Stream<int[]>
                .toArray(int[][]::new);
        return arrays;
    }
}
