package stringCode;
/*
* 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
示例 1：
输入：s = "We are happy."
输出："We%20are%20happy."
限制：
0 <= s 的长度 <= 10000
* */
public class Solution_replaceSpace {
    public static void main(String[] args) {

        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
    static String replaceSpace(String s){
        char[] chars = s.toCharArray();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                buffer.append("%20");
            }else {
                buffer.append(chars[i]);
            }
        }
        return buffer.toString();
    }
}
