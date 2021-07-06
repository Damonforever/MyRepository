package arrayCode;

public class Solution_uniquePaths {
    public static void main(String[] args) {
        int m= uniquePaths(5,5);
        System.out.println(m);
    }

    static int uniquePaths(int m, int n) {
        int target=0;
        int target1=0;
        int target2=0;
        int n1=1;
        int m1=1;
        if(n==1){
            target=1;
        }
        if(m==1){
            target=1;
        }


        return target;
    }
}
