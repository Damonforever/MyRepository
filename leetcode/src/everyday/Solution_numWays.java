package everyday;

public class Solution_numWays {
    public static void main(String[] args) {
        int n = 70;
        System.out.println(numWays(n));
    }
    static int numWays(int n) {
//        int sum1 = 0;
////        int sum2 =0;
////        int sum = 0;
////        if(n%2==0){
////            sum2 = n/2;
////            if(sum2==0){
////                count = 1;
////            }else{
////                count++;
////                sum2--;
////                sum1 += 2;
////                while(sum2>0){
////                    int t1 = 1;
////                    if(sum1>sum2){
////                        sum=sum1;
////                    }else {
////                        sum=sum2;
////                    }
////                    for (int i = sum1 + sum2, j = sum; i > sum; i--,j--) {
////                        t1 *=i;
////                        t1 /=j;
////                    }
////
////                    count = count%1e9+7;
////                    count +=(t1%1e9+7);
////                    sum2--;
////                    sum1 +=2;
////                }
////                count++;
////            }
////        }else{
////            sum1 = 1;
////            sum2 = n/2;
////            if(sum2==0){
////                count = 1;
////            }else{
////                while(sum2>0){
////                    int t1 = 1;
////                    if(sum1>sum2){
////                        sum=sum1;
////                    }else {
////                        sum=sum2;
////                    }
////                    for (int i = sum1 + sum2, j = sum; i > sum; i--,j--) {
////                        t1 *=i;
////                        t1 /=j;
////
////                    }
////                    count = count%1e9+7;
////                    count +=(t1%1e9+7);
////                    sum2--;
////                    sum1 +=2;
////                }
////                count++;
////            }
////        }
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
