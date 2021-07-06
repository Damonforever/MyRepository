package stringCode;

import java.util.ArrayList;

public class Solution_reorganizeString {
    public static void main(String[] args) {
        String str = "cxmwmmm";
        char[] chars = str.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Character> list1 = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i]);
        }
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            int m = 0;
            if (i == 0) {
                list1.add(list.get(i));
                list.remove(i);
                count++;

            } else {
                while (m < list.size()) {
                    if (list1.get(i - 1) == list.get(m)) {
                        m++;
                    } else {
                        list1.add(list.get(m));
                        list.remove(m);
                        count++;
                        break;

                    }


                }
                if (count <= i) {
                    m = 0;
                    while (m < list.size()) {
                        if (list1.get(0) != list.get(m)) {
                            int len = list1.size()-1;
                            list1.add(list1.get(len));
                            for (int j = 0; j < len; j++) {
                                list1.set(len-j, list1.get(len - j-1));
                            }
                            list1.set(0, list.get(m));
                            list.remove(m);
                            count++;
                            break;
                        } else {
                            m++;
                        }
                    }
                    if(count<=i){
                        break;
                    }
                }

            }

        }
        int j = 0;
        for (char ch : list1) {
            chars[j] = ch;
            j++;
        }
        if (count < chars.length) {
            String s = "-1";
            System.out.println(s);
            System.out.println(count);
            System.out.println(list);
        } else {
            String s1 = String.valueOf(chars);
            System.out.println(s1);
            System.out.println(count);
        }
//        String str = "baaba";
//        char[] chars = str.toCharArray();
//        ArrayList<Character> list = new ArrayList<>();
//        ArrayList<Character> list1 = new ArrayList<>();
//        for (int i = 0; i < chars.length; i++) {
//            list.add(chars[i]);
//        }
//        int count=0;
//        for (int i = 0; i < chars.length; i++) {
//            int m=0;
//            if(i==0){
//                list1.add(list.get(i));
//                list.remove(i);
//                count++;
//                System.out.println(list);
//
//            }else {
//                while(m<list.size()){
//                    if(list1.get(i-1)==list.get(m)){
//                        m++;
//                    }else{
//                        list1.add(list.get(m));
//                        list.remove(m);
//                        count++;
//                        break;
//
//                    }
//                    System.out.println(list);
//                }
//            }
//
//        }
//        int j =0;
//        for (char ch: list1){
//            chars[j]=ch;
//            j++;
//        }
//        if(count<chars.length){
//            String s = "";
//            System.out.println(s);
//            System.out.println(count);
//            System.out.println(list);
//        }else {
//            String s1 =String.valueOf(chars);
//            System.out.println(s1);
//            System.out.println(count);
//        }
    }
//    static String reorganizeString(String S){
//        char[] chars = S.toCharArray();
//        ArrayList<Character> list = new ArrayList<>();
//        for (int i = 0; i < chars.length; i++) {
//            list.add(chars[i]);
//        }
//        int count=0;
//        for (int i = 0; i < chars.length; i++) {
//            int m=0;
//            if(i==0){
//                chars[i]=list.get(i);
//                list.remove(i);
//                count++;
//            }else {
//                while(m<list.size()){
//                    if(chars[i-1]==list.get(m)){
//                        m++;
//                    }else{
//                        chars[i]=list.get(m);
//                        list.remove(m);
//                        count++;
//                        m++;
//                    }
//                }
//                if(i<count){
//                    break;
//                }
//            }
//
//        }
//        if(count<chars.length){
//            String s = "";
//            return s;
//        }else {
//            String s1 =String.valueOf(chars);
//            return s1;
//        }
//
//    }
}
