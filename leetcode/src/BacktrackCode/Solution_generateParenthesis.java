package BacktrackCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: 括号的生成
 * @author: Damon
 * @date: 2021/8/8 16:25
 */
public class Solution_generateParenthesis {
    //自己写的效率很低
    Set<String> res = new HashSet<>();
    public static void main(String[] args) {
        System.out.println(new Solution_generateParenthesis().generateParenthesis1(3));
    }
    public List<String> generateParenthesis(int n) {
        char[] chars = new  char[]{'(',')'};
        StringBuilder sb = new StringBuilder();
        backtrack(chars,sb,2*n);
        return new ArrayList<>(res);
    }
    void backtrack(char[] chars,StringBuilder sb,int m){
        if (sb.length() == m){
            if (isValid(sb.toString())) res.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            backtrack(chars,sb,m);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    boolean isValid( String s){
        char[] chars = s.toCharArray();
        if (chars[0] == ')' || chars[chars.length - 1] == '(') return false;
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '(') stack.push(chars[i]);
            else {
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
    /**********************************************************/

//书上的方法
    public List<String> generateParenthesis1(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder track = new StringBuilder();
        //可用初始化左括号和右括号的数量初始化为n
        backtrack1(n,n,track,result);
        return result;
    }
    void backtrack1(int left, int right, StringBuilder track, List<String> result){
        if (left < 0 || right < 0) return;
        if (right < left) return;
        if (left == 0 && right == 0) {
            result.add(track.toString());
            return;
        }
        track.append('(');
        backtrack1(left - 1, right, track,result);
        track.deleteCharAt(track.length() - 1);

        track.append(')');
        backtrack1(left, right - 1, track,result);
        track.deleteCharAt(track.length() - 1);
    }
}
