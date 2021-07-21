package dpCode;

public class Solution_longestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        int[][] dp = new int[m][m];
        for (int i = 0; i < m; i++) {
            dp[i][i] = 1;
        }
        for (int i = m-2; i >= 0; i--) {
            for (int j = i + 1; j < m; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][m-1];
    }
    //降维打击
    public int longestPalindromeSubseq1(String s) {
        int m = s.length();
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }
        for (int i = m-2; i >= 0; i--) {
            int pre = 0;
            for (int j = i + 1; j < m; j++) {
                int temp = dp[j];
                if(s.charAt(i) == s.charAt(j)){
                    dp[j] = pre + 2;
                }else{
                    dp[j] = Math.max(dp[j],dp[j-1]);
                }
                pre = temp;
            }
        }
        return dp[m-1];
    }
}
