package stringCode;

public class Solution_reverseLeftWords {
    public static void main(String[] args) {
        String s = "asdfghj";
        System.out.println(reverseLeftWords(s,2));
    }
    static String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n));
        sb.append(s, 0, n);
        return sb.toString();
    }
}
