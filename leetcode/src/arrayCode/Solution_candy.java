package arrayCode;
//位运算
public class Solution_candy {
    public static void main(String[] args) {
        int[] num ={3,2,1,1,4,3,3};
        System.out.println(candy(num));
    }
    static int candy(int[] ratings) {
        int sum=0;
        boolean flag1 =false;
        int[] num = new int[ratings.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = 1;
        }
        if(num.length>1){
            boolean flag = true;

            int s = 1;
            while(s>0){
                if(ratings[0]>ratings[1]){
                    while (num[0]<=num[1]){
                        num[0]++;
                    }
                }
                for (int j = 1; j < ratings.length-1; j++) {
                    if(ratings[j-1]<ratings[j]){
                        while (num[j-1]>=num[j]){
                            num[j]++;
                        }
                    }
                    if(ratings[j+1]<ratings[j]){
                        while(num[j+1]>=num[j]){
                            num[j]++;
                            flag1=true;

                        }
                        if(flag1){
                            for(int m = j; m>0;m--){
                                if(ratings[m-1]>ratings[m]){
                                    while(num[m-1]<=num[m]){
                                        num[m-1]++;
                                    }
                                }
                            }
                        }
                    }
                    if(flag1){

                        flag1=false;
                    }

                }
                s--;
            }
            if (ratings[ratings.length-2]<ratings[ratings.length-1]){
                while(num[ratings.length-2]>=num[ratings.length-1]){
                    num[ratings.length-1]++;
                }
            }
            for (int i = 0; i < num.length; i++) {
                sum+=num[i];
            }
        }else{
            sum=1;
        }
        return sum;
    }
}
