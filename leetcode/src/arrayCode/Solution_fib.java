package arrayCode;

public class Solution_fib {
    public static void main(String[] args) {
        System.out.println(fib1(81));
    }
    static int fib1(int n){
        double d =(double)n;
        double target=-1;
        double f0 =0;
        double f1 =1;
        if(d==0) {
            target = 0;
        }
        if (d==1){
             target = 1;
        }
        for (int i= 2;i<=n;i++){
            target = (f0+f1)%(1e9+7);
            f0 = f1;
            f1=target;
        }

        n=(int)target;
        return n;

    }
}
