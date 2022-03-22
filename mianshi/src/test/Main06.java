package test;
import java.util.*;
public class Main06 {
    private static boolean isMatch(String str, int maxLetters) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
            if (set.size() > maxLetters) {
                return false;
            }
        }
        return set.size() <= maxLetters;
    }
    public static int maxFreq(String s) {
        int len = s.length();
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (i + 1 > len) {
                break;
            }
            String sub = s.substring(i, i + 1);
            if (isMatch(sub, 26)) {
                countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
            }
        }
        int ansMax = 0;
        for (String str: countMap.keySet()) {
            int count = countMap.get(str);
            if (count > ansMax) {
                ansMax = count;
            }
        }
        return ansMax;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(maxFreq(s));
    }

}
