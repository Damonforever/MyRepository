package dpCode;

/**
 * @description:  回文子串
 * @author: Damon
 * @date 2021/9/21 21:10
 */
public class Solution_countSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaaaa"));
    }
    public static int countSubstrings(String s) {
        int len = s.length();
        if (len == 1) return 1;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String sub = s.substring(i,j+1);
                if (sub.length() % 2 == 0){
                    int l  = sub.length()/2 - 1;
                    int r = sub.length()/2;
                    while (l >=0 && r <= sub.length() - 1 && sub.charAt(l) == sub.charAt(r)){
                        l--;
                        r++;
                    }
                    if (l == -1 && r == sub.length()) count++;
                }else {
                    int l = sub.length()/2 - 1;
                    int r = sub.length()/2 + 1;
                    while (l >=0 && r <= sub.length() - 1 && sub.charAt(l) == sub.charAt(r)){
                        l--;
                        r++;
                    }
                    if (l == -1 && r == sub.length()) count++;
                }
            }
        }
        return count;
    }
}
