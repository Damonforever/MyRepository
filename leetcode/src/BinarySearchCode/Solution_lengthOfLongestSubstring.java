package BinarySearchCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description: 无重复字符的最长子串
 * @author: Damon
 * @date 2021/8/3 16:27
 */
public class Solution_lengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("aab"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLen = 0;
        Map<Character, Integer> index = new HashMap<>();
        Set<Character> set = new HashSet<>();
        while (right < s.length()){
            char ch = s.charAt(right);
            if (set.add(ch)) {
                index.put(ch,right);
                maxLen = Math.max(maxLen,set.size());
            }else {
                left = index.get(ch) + 1;
                for (Map.Entry<Character, Integer> entry : index.entrySet()) {
                    if (entry.getValue() < left) set.remove(entry.getKey());
                }
                set.add(ch);
                index.put(ch,right);
            }
            right++;
        }
        return maxLen;
    }
    public static int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, maxLen = 0;
        while (right < s.length()){
            char ch = s.charAt(right);
            right++;
            window.put(ch, window.getOrDefault(ch,0) + 1);
            while (window.get(ch) > 1){
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            maxLen = Math.max(maxLen,right - left);
        }
        return maxLen;
    }
}
