package aiqiyi;

import java.util.*;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/1 15:44
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        if (sc.hasNextLine()){
            sb.append(sc.nextLine());
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i)!= '[' && sb.charAt(i)!= ']' && sb.charAt(i)!= ',') list.add(sb.charAt(i) - 48);
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        int[] res = my(nums);
        StringBuilder sb1 = new StringBuilder();
        sb1.append("[");
        for (int i = 0; i < res.length; i++) {
            sb1.append("" + res[i]);
            sb1.append(",");
        }
        if(sb1.length() > 1) sb1.deleteCharAt(sb1.length()-1);
        sb1.append("]");
        System.out.println(sb1.toString());
    }
    private static int[] my(int[] rains){
        int[] result = new int[rains.length];
        Arrays.fill(result,-1);
        Map<Integer,Integer> pos = new HashMap<>();
        LinkedList<Integer> zeros = new LinkedList<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                if (pos.containsKey(rains[i])){
                    int pre = pos.get(rains[i]);
                    if (zeros.size() == 0 || zeros.getLast() < pre) return new int[0];
                    int day = -1;
                    Iterator<Integer> iterator = zeros.iterator();
                    while ((day = iterator.next()) <= pre);
                    iterator.remove();
                    result[day] = rains[i];
                }
                pos.put(rains[i],i);
            }else {
                zeros.add(i);
            }
        }
        for (Integer zero : zeros) {
            result[zero] = 1;
        }
        return result;
    }
}
