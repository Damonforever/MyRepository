package arrayCode;

public class Solution_monotoneIncreasingDigits {
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(332));
    }
    static int monotoneIncreasingDigits(int N) {
        boolean flag= true;
        int t= N;
        int sum = 0;
        while (t/10!=0){
            sum++;
            t=t/10;
        }
        t=N;
        sum++;
        int[] num = new int[sum];
        for (int i = sum-1; i>0; i--) {
            num[i]=N%10;
            N=N/10;
        }
        num[0]=N;
        if(sum>1){
            while(flag){
                for(int j = 0;j<num.length-1;j++){
                    if(num[j]>num[j+1]){
                        int m =j+1;
                        num[j] = num[j]-1;
                        while(m<num.length){
                            num[m]=9;
                            m++;
                        }
                        flag=true;
                        break;
                    }
                    flag=false;
                }
            }
            N=0;
            if(num[0]!=0){

                for( int l = 0;l<num.length;l++){
                    N=N*10+num[l];
                }
            }else{
                for( int l = 1;l<num.length;l++){
                    N=N*10+num[l];
                }
            }
        }else{
            N=t;
        }

        return N;
    }

}
