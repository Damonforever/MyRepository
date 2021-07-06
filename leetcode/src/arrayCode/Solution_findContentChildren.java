package arrayCode;

import java.util.Arrays;

public class Solution_findContentChildren {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {3};
        System.out.println(findContentChildren(g,s));
    }
    static int findContentChildren(int[] g, int[] s) {
        int count  = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        if(s.length>0){
            for (int i = 0; i < g.length; i++) {
                if(j<s.length && s[j]>=g[i]){
                    count++;
                    j++;
                }else {
                    while(j<s.length &&s[j]<g[i]){
                        j++;
                    }
                    if(j<s.length && s[j]>=g[i]){
                        count++;
                        j++;
                    }else {
                        break;
                    }
                }
            }
        }
        return count;
    }
}
