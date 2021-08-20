package dpCode;

/**
 * @description: 最长回文子串
 * @author: Damon
 * @date 2021/7/20 16:53
 */
public class Solution_longestPalindrome {
    public static void main(String[] args) {
        System.out.println(new Solution_longestPalindrome().longestPalindrome1("babad"));
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) break;

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    //非动态规划
    public String longestPalindrome1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s,i,i);
            String s2 = palindrome(s,i,i+1);
            if (sb.length() < s1.length()) {
                if (sb.length() > 0){
                    sb.delete(0,sb.length());
                }
                sb.append(s1);
            }
            if (sb.length() < s2.length()) {
                if (sb.length() > 0){
                    sb.delete(0,sb.length());
                }
                sb.append(s2);
            }
        }
        return sb.toString();
    }
    String palindrome(String s,int l, int r){
        //防止索引越界
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        //不进入while循环操作时，会出现左侧边界大于右侧边界的情况
        return s.substring(l + 1, r);
    }
}
