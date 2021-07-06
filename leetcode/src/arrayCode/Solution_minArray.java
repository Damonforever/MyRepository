package arrayCode;

public class Solution_minArray {
    public static void main(String[] args) {
        int[] arr = {1,3,3};
        System.out.println(minArray(arr));
    }

    static int minArray(int[] numbers) {
        int len = numbers.length-1;
        while(true){
            if(len>0 && numbers[len]>=numbers[len-1]){
                len--;
            }else {
                break;
            }
        }
        return numbers[len];
    }
}
