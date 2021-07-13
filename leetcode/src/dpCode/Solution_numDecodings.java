package dpCode;

/**
 * @description: 解码方法
 * @author: Damon
 * @date 2021/7/13 17:02
 */
public class Solution_numDecodings {
    public static void main(String[] args) {
        System.out.println(numDecodings("207"));
    }
    public static int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        if(s.length() <= 1) return 1;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if (s.charAt(1) == '0') {
            if(s.charAt(0) <= '2'){
                dp[1] = 1;
            }else {
                return 0;
            }
        }else {
            if (s.substring(0,2).compareTo("26") <= 0){
                dp[1] = 2;
            }else {
                dp[1] = 1;
            }
        }
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '0'){
                if ('1' <= s.charAt(i - 1) && s.charAt(i - 1) <= '2'){
                    dp[i] = dp[i - 2];
                }else {
                    return 0;
                }
            }else {
                if(s.charAt(i-1) == '0'){
                    dp[i] = dp[i - 1];
                }else {
                    if (s.substring(i-1,i+1).compareTo("26") <= 0){
                        dp[i] = dp[i - 1] + dp[i - 2];
                    }else {
                        dp[i] = dp[i-1];
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}
