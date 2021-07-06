package dpCode;

/**
 * @description: 把数字翻译成字符串
 * @author: Damon
 * @date 2021/7/2 11:23
 */
public class Solution_translateNum {
    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length()];
        dp[0] = 1;
        dp[1] = 1;
        if(s.substring(0,2).compareTo("25") <= 0 && s.substring(0,2).compareTo("10") >= 0) dp[1] = 2;
        for (int i = 0; i < s.length(); i++) {
            int c = 0;
            if(i == 0 || i == 1) continue;
            if(s.substring(i-1,i+1).compareTo("25") <= 0 && s.substring(i-1,i + 1).compareTo("10") >= 0) c = 1;
            dp[i] = dp[i - 1] + dp[i - 2]*c;
        }
        return dp[s.length()-1];
    }
}
