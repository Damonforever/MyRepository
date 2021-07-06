package arrayCode;

import java.util.ArrayList;

public class Solution_lastRemaining {
    public static void main(String[] args) {
        System.out.println(lastRemaining(10,17));
    }
    static int lastRemaining(int n, int m) {
        ArrayList<Integer> array = new ArrayList<>();
        int count = 1;
        if(m != 1){
            for (int i = 0; i < n; i++) {
                if(count % m == 0){
                    count++;
                    continue;
                }else {
                    array.add(i);
                    count++;
                }
            }
        }else{
            return n-1;
        }
        while (array.size() > 1){
            for (int i = 0; i < array.size(); i++) {
                if(count % m == 0){
                    array.remove(i);
                    i--;
                }
                count++;
            }
        }
        return array.get(0);
    }
}
