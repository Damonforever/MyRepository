package BacktrackCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 电话号码的生成
 * @author: Damon
 * @date 2021/8/7 18:40
 */
public class Solution_letterCombinations {
    Map<Character,String> index = new HashMap<>();
    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new Solution_letterCombinations().letterCombinations("23"));
    }
    public  List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        index.put('2',"abc");
        index.put('3',"def");
        index.put('4',"ghi");
        index.put('5',"jkl");
        index.put('6',"mno");
        index.put('7',"pqrs");
        index.put('8',"tuv");
        index.put('9',"wxyz");
        char[] chars = digits.toCharArray();
        int len = digits.length();
        StringBuilder sb = new StringBuilder();
        backtrack(chars,0,len,sb);
        return res;
    }
    void backtrack(char[] chars,int n,int len,StringBuilder sb){
        if (sb.length() == len){
            res.add(sb.toString());
            return;
        }
        for (int i = n; i < chars.length; i++) {
            String str = index.get(chars[i]);
            for (int j = 0; j < str.length(); j++) {
                sb.append(str.charAt(j));
                backtrack(chars,n+1,len,sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
