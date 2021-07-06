package dpCode;

public class Solution_climbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
    static int climbStairs(int n) {
        int m = 1;
        int s = 2;
        if(n == 1){
            return m;
        }
        if(n == 2){
            return s;
        }
        for (int i = 3; i <= n; i++) {
            int temp = m + s;
            m = s;
            s = temp;
        }
        return s;
    }

}
