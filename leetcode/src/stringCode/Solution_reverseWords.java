package stringCode;

public class Solution_reverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
    static String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--){

            if(i == str.length - 1){
                sb.append(str[i]);
            }else {
                if(!str[i].equals("")){
                    sb.append(" ");
                    sb.append(str[i]);
                }
            }
        }
        return sb.toString();
    }
}
