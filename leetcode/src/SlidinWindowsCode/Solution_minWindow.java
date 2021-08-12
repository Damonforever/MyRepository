package SlidinWindowsCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 最小覆盖子串
 * @author: Damon
 * @date 2021/8/3 9:32
 */
public class Solution_minWindow {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBAECODEBNC","ABC"));
    }
    public static String minWindow(String s, String t) {
        //存储t中需要被找到的字符及其个数
        Map<Character, Integer> need = new HashMap<>();
        //存储窗口中可以被找到的t中包含的字符及其个数
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
        }
        int left = 0, right = 0;
        int valid = 0;
        //存储符合要求的子串的开始位置以及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()){
            char ch = s.charAt(right);
            right++;
            if (need.containsKey(ch)){
                window.put(ch, window.getOrDefault(ch,0) + 1);
                //Integer做比较时务必使用equals
                if (window.get(ch).equals(need.get(ch))) valid++;
            }
            while (valid == need.size()){
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    //Integer做比较时务必使用equals
                    if (window.get(d).equals(need.get(d))) valid--;
                    window.put(d,window.get(d)-1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
}
