package dpCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 单词拆分
 * @author: Damon
 * @date 2021/7/12 9:59
 */
public class Solution_wordBreak {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(wordBreak("leetcode",list));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
