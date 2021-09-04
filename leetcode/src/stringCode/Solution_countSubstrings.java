package stringCode;

import java.util.HashMap;

/**
 * @description: 统计只差一个字符的子串数目
 * @author: Damon
 * @date 2021/9/1 21:19
 */
//暴力枚举，用map存储测试过的，但是有bug
public class Solution_countSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings("ab","bb"));
    }
    public static int countSubstrings(String s, String t) {
        HashMap<String,Integer> map = new HashMap<>();
        int len = s.length();
        int count = 1;
        int result = 0;
        while(count <= len){
            for(int i = 0; i < len - count + 1; i++){
                String substring = s.substring(i, i + count);
                if(map.containsKey(substring)){
                    result += map.get(substring);
                }else {
                    boolean flag = false;
                    for(int j = 0; j < t.length() - count + 1; j++){
                        if(judge(substring,t.substring(j,j+count))){
                            map.put(substring,map.getOrDefault(substring,0) + 1);
                            flag = true;
                        }
                    }
                    if(!flag) {
                        map.put(substring,0);
                    }
                    result += map.get(substring);
                }
            }
            count++;
        }
        return result;
    }
    public static boolean judge(String s1, String t1){
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != t1.charAt(i)) count++;
            if(count > 1) return false;
        }
        if (s1.length() == 1 ) {
            return count == 1;
        }
        return s1.length() - 1 == count;
    }
}
