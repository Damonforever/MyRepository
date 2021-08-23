package bishicode.wangyi;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/21 15:37
 */
public class Solution1 {
    public char findKthBit (int n, int k) {
        // write code here
        char[] cs = new char[27];
        for (int i = 1; i < 27; i++) {
            cs[i] = (char) ('a' + i -1);
        }
        String[] strings = new String[n+1];
        strings[1] = "a";
        for (int i = 2; i <= n; i++) {
            strings[i] = strings[i-1] + cs[i] + reverse(strings[i-1]);
        }
        return strings[n].charAt(k-1);
    }
    private static String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            char ch = (char) ('z' - (c - 'a'));
            sb.append(ch);
        }
        return sb.reverse().toString();
    }
}
