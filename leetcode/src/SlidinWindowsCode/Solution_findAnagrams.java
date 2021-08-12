package SlidinWindowsCode;

import java.util.*;

/**
 * @description: 找到字符串中所有字母异位词
 * @author: Damon
 * @date 2021/8/3 15:59
 */
public class Solution_findAnagrams {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd","abc"));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            need.put(ch,need.getOrDefault(ch,0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        List<Integer> result = new ArrayList<>();
        while (right < s.length()){
            char ch = s.charAt(right);
            right++;
            if (need.containsKey(ch)){
                window.put(ch,window.getOrDefault(ch,0) + 1);
                if (window.get(ch).equals(need.get(ch))) valid++;
            }
            while (valid == need.size()){
                char out = s.charAt(left);
                if (need.containsKey(out)){
                    if (need.get(out).equals(window.get(out))){
                         if (right - left == p.length()) result.add(left);
                        valid--;
                    }
                    window.put(out,window.get(out) - 1);
                }
                left++;
            }
        }
        return result;
    }
}
