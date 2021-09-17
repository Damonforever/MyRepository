package bishicode.rongyao;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/12 20:40
 */
public class Main5 {
    public static void main(String[] args) {
        System.out.println(helper("我ABC汉DEF", 6));
    }
    static String helper(String s,int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                if (n > 0){
                    sb.append(s.charAt(i));
                    n--;
                }else break;
            }else {
                if (n > 1){
                    sb.append(s.charAt(i));
                    n -=2;
                }else break;
            }
        }
        return sb.toString();
    }
}
