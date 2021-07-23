package dpCode;

/**
 * @description: 判断子序列
 * @author: Damon
 * @date 2021/7/22 17:04
 */
public class Solution_isSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;
        int index = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = index; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)){
                    index = j + 1;
                    count++;
                    break;
                }
            }
            if (count <= i) return false;
        }
        return count == s.length();
    }
}
