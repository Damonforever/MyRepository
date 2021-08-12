package SlidinWindowsCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 字符串的排列
 * @author: Damon
 * @date 2021/8/3 15:30
 */
public class Solution_checkInclusion {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidboaoo"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            need.put(c1,need.getOrDefault(c1,0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()){
            char ch = s2.charAt(right);
            right++;
            if (need.containsKey(ch)){
                window.put(ch,window.getOrDefault(ch,0) + 1);
                if (window.get(ch).equals(need.get(ch))) valid++;
            }
            while (right - left >= s1.length()){
                if (valid == need.size()) return true;
                char out = s2.charAt(left);
                left++;
                if (need.containsKey(out)){
                    if (need.get(out).equals(window.get(out))) valid--;
                    window.put(out,window.get(out) - 1);
                }
            }
        }
        return false;
    }
}
