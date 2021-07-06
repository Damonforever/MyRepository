package regularExpressionCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution_isNumber {
    public static void main(String[] args) {
        System.out.println(isNumber("  3.5e1 "));
    }
    static boolean isNumber(String s) {
        String pattern = "\\s*[\\+\\-]?(([0-9]+\\.[0-9]*|\\.[0-9]+)|([0-9]+))([eE][\\+\\-]?[0-9]+|\\s*)\\s*";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);
        return m.matches();

    }
}
