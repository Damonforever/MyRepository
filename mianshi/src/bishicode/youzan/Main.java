package bishicode.youzan;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/21 10:27
 */
public class Main {
    public boolean isMatch(String s, String p){
        int m1 = s.length();
        int n1 = p.length();
        boolean[][] flags = new boolean[m1 + 1][n1 + 1];
        flags[0][0] = true;
        for (int i = 0; i <= m1; i++) {
            for (int j = 1; j <= n1; j++) {
                if (p.charAt(j - 1) == '*'){
                    flags[i][j] = flags[i][j - 2];
                    if (match(s,p,i,j-1)){
                        flags[i][j] = flags[i][j] || flags[i-1][j];
                    }
                }else {
                    if (match(s,p,i,j)) flags[i][j] = flags[i-1][j-1];
                }
            }
        }
        return flags[m1][n1];
    }
    boolean match(String s, String p, int i, int j){
        if (i == 0) return false;
        if (p.charAt(j - 1) == '.') return true;
        return s.charAt(i -  1) == p.charAt(j - 1);
    }
}
