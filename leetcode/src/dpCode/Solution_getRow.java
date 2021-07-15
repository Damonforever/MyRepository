package dpCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 杨辉三角2
 * @author: Damon
 * @date 2021/7/15 19:46
 */
public class Solution_getRow {
    public static void main(String[] args) {
        System.out.println(getRow(10));
    }
    //O(k+1)
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        rowIndex++;
        list.add(1);
        int temp1 = 0;
        for (int i = 1; i < rowIndex; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) ;
                else if (j == i) list.add(1);
                else {
                    if (temp1 == 0){
                        temp1 = list.get(j);
                        list.set(j,temp1 + list.get(j - 1));
                    }else {
                        list.set(j,temp1 + list.get(j));
                        temp1 = list.get(j) - temp1;
                    }
                }
            }
            temp1 = 0;
        }
        return list;
    }
    //O(k+2)
//    public static List<Integer> getRow(int rowIndex) {
//        List<Integer> list = new ArrayList<>();
//        rowIndex++;
//        list.add(1);
//        int temp1 = 0, temp2 = 0;
//        for (int i = 1; i < rowIndex; i++) {
//            for (int j = 0; j < i + 1; j++) {
//                if (j == 0) ;
//                else if (j == i) list.add(1);
//                else {
//                    if (temp1 == 0 && temp2 == 0){
//                        temp1 = list.get(j - 1);
//                        temp2 = list.get(j);
//                    }
//                    list.set(j,temp1 + temp2);
//                    if (j + 1 < i){
//                        temp1 = temp2;
//                        temp2 = list.get(j +1);
//                    }
//                }
//            }
//            temp1 = temp2 = 0;
//        }
//        return list;
//    }
}
