package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/4 16:37
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split("\\|");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            StringBuilder sb = new StringBuilder();
            String[] split = strings[i].split(" ");
            if (i == 0){
                if (Integer.parseInt(split[0]) != 1){
                    System.out.println("error");
                    return;
                }
                if (!split[1].equals("i")){
                    System.out.println("error");
                    return;
                }
                for (int j = 2; j < split.length; j++) {
                    sb.append(split[j]);
                    if (j != split.length -1) sb.append(" ");
                }
                list.add(sb.toString());
            }else {
                for (int j = 2; j < split.length; j++) {
                    sb.append(split[j]);
                    if (j != split.length -1) sb.append(" ");
                }
                int row = Integer.parseInt(split[0]);
                if (row <= list.size()){
                    if (split[1].equals("i")){
                        list.add(sb.toString());
                        for(int j = list.size() - 1; j >= row; j--){
                            list.set(j, list.get(j - 1));
                        }
                        list.set(row - 1,sb.toString());
                    }else if (split[1].equals("a")){
                        list.add(sb.toString());
                        for(int j = list.size() - 1; j >= row; j--){
                            list.set(j, list.get(j - 1));
                        }
                        list.set(row,sb.toString());
                    }else if (split[1].equals("d")){
                        list.remove(row-1);
                    }else {
                        list.set(row-1,sb.toString());
                    }
                }else {
                    System.out.println("error");
                    return;
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
