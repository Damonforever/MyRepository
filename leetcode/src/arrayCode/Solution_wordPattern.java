package arrayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution_wordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("aba","dog cat cat"));
    }
    static boolean wordPattern(String pattern, String s) {
        boolean flag = true;
        int count = 1;
        for (int n = 0; n < s.length(); n++) {
            if(s.charAt(n)==' '){
                count++;
            }
        }
        if(count == pattern.length()){
            int len = pattern.length();
            boolean[] judge = new boolean[len];
            boolean flag1 = true;
            String[] str = new String[len];
            int j = 0;
            for (int i = 0; i < s.length(); i++) {

                if(s.charAt(i)==' '){
                    j=j+1;
                    continue;
                }
                if(str[j]==null){
                    str[j]=String.valueOf(s.charAt(i));
                }else{
                    str[j]=str[j]+String.valueOf(s.charAt(i));
                }
            }
            for (int k = 0; k < pattern.length(); k++) {
                if(judge[k]==false){
                    judge[k]=true;
                    for (int m = k+1; m < pattern.length(); m++) {
                        if(judge[m]==false && pattern.charAt(k)==pattern.charAt(m)){
                            if(str[k].equals(str[m])){
                                judge[m]=true;
                            }else{
                                flag1=false;
                                break;
                            }
                        }
                        if(judge[m]==false && pattern.charAt(k)!=pattern.charAt(m)){
                            if(str[k].equals(str[m])){
                                flag1=false;
                                break;
                            }
                        }

                    }
                }
                if(!flag1){
                    flag=false;
                    break;
                }
            }
        }else{
            flag=false;
        }

        return flag;
    }
}
