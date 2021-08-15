package bishicode.aiqiyi;

import java.util.*;

/**
 * @description: 一个全为小写字母的字符串，移除前k小值
 * @author: Damon
 * @date: 2021/8/13 20:14
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        String[] strings = input.split(",");
        if (strings[0] == null){
            System.out.println("");
            return;
        }
        int k = Integer.parseInt(strings[1]);
        if (k == 0){
            System.out.println(strings[0]);
            return;
        }
        //去双引号转数组
        char[] chars = strings[0].substring(1,strings[0].length() - 1).toCharArray();
        Arrays.sort(chars);
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(chars[i],map.getOrDefault(chars[i],0) + 1);
        }
        StringBuilder sb = new StringBuilder(strings[0]);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (map.size() == 0) break;
            if (map.containsKey(ch)){
                if (map.get(ch) == 0){
                    map.remove(ch);
                    continue;
                }
                map.put(ch,map.get(ch)-1);
                sb.deleteCharAt(i);
                i--;
            }
        }

    }

}
