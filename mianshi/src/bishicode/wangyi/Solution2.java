package bishicode.wangyi;

import java.util.*;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/21 15:56
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> lists = new ArrayList<>();
        String str = scanner.nextLine();
        int pre = 0;
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                List<Integer> list = new ArrayList<>();;
                list.add(j++);
                list.add(Integer.parseInt(str.substring(pre,i)));
                lists.add(list);
                pre = i+ 1;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(j);
        list.add(Integer.parseInt(str.substring(pre,str.length())));
        lists.add(list);
        lists.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        });
        int[][] flags = new int[lists.size()][2];
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> listTmp = lists.get(i);
            flags[listTmp.get(0)][1] = listTmp.get(1);
            if (listTmp.get(0) == 0) {
                if (flags[0][1] > flags[1][1]){
                    flags[0][0] = flags[1][0]+1;
                }else {
                    flags[0][0] = 1;
                }
            }else if (listTmp.get(0) == lists.size() -1){
                if(flags[lists.size()-1][1] > flags[lists.size()-2][1]){
                    flags[lists.size()-1][0] = flags[lists.size()-2][0]+1;
                }else {
                    flags[lists.size() -1][0] =1;
                }
            }else {
                if (flags[i][1] == Math.max(flags[i-1][1],flags[i+1][1])){
                    flags[i][0] = Math.max(flags[i-1][0],flags[i+1][0]);
                }else {
                    flags[i][0] = Math.max(flags[i-1][0],flags[i+1][0]) +1;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < flags.length; i++) {
            sum += flags[i][0];
        }
        System.out.println(sum);
    }

}
