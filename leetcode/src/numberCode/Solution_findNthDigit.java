package numberCode;

/**
 * @description: 数字序列中某一位的数字
 * @author: Damon
 * @date 2021/7/3 10:00
 */
public class Solution_findNthDigit {
    public static void main(String[] args) {
        System.out.println(findNthDigit(11));
    }
    public static int findNthDigit(int n) {
        if (n < 10) return n;
        long m = n + 1;
        long[] index = new long[31];
        index[0] = 10;
        int getIndex;
        for (getIndex = 1; getIndex  < index.length; getIndex ++) {
            index[getIndex] = index[getIndex - 1] + (long) Math.pow(10,getIndex) * (getIndex + 1) *9;
            if(index[getIndex] > n) break;
        }
        //拿到是几位数
        int digit = getIndex + 1;
        //还差多少位
        long count = m - index[getIndex - 1];
        //余数
        int remainder = (int) count % digit;
        //根据位数判断要后移多少个
        int num = (int) count / digit;
        //算出起始的数字
        long start = (long) Math.pow(10,getIndex);
        long trueNum;
        long res;
        if(remainder == 0){
            trueNum = start + num - 1;
            res = trueNum % 10;
        }else {
            trueNum = start + num;
            String str = String.valueOf(trueNum);
            res = Integer.parseInt(str.substring(remainder - 1,remainder));
        }
        return (int) res;
    }
}
