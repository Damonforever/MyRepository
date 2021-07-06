package arrayCode;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_firstUniqChar {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }
    static char firstUniqChar(String s) {
//        if(s.length()<1){
//            char ch = ' ';
//            return ch;
//        }else{
//            Set<Character> set = new HashSet<>();
//            List<Character> list = new ArrayList<>();
//            for (int i = 0; i < s.length(); i++) {
//                if(set.add(s.charAt(i))){
//                    list.add(s.charAt(i));
//                }else{
//                    if(list.contains(s.charAt(i))){
//                        list.remove(s.charAt(i));
//
//                    }
//                }
//
//            }
//            if(list.isEmpty()){
//                char ch = ' ';
//                return ch;
//            }else {
//                return list.get(0);
//            }
//        }

        if(s.length()<1){
            char ch = ' ';
            return ch;
        }else{
            char ch = ' ';
            for (int i = 0; i < s.length(); i++) {
                if(s.indexOf(s.charAt(i))==s.lastIndexOf(s.charAt(i))){
                    ch = s.charAt(i);
                    break;
                }
            }
            return ch;
        }
    }
}
