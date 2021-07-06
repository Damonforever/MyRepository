package arrayCode;

public class Solution_countPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10000));
    }

    static int countPrimes(int n){
        int num=0;
        for(int i =2;i<n;i++){
            boolean flag =true;
            for(int j=2;j*j<=i;j++){
                if(i%j==0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                num++;
            }
            flag = true;
        }
        return num;
    }
}
