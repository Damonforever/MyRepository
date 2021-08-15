package SlidinWindowsCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/12 20:41
 */
public class Test {
    public static void main(String[] args) {
        
    }
    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            need.put(ch,need.getOrDefault(ch,0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c,window.getOrDefault(c,0) + 1);
                if (window.get(c).equals(need.get(c))) valid++;
            }
            while (valid == need.size()){
                if (right - left < len){
                    len = right - left;
                    start = left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))) valid--;
                    window.put(d,window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
}
