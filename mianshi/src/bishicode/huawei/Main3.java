package bishicode.huawei;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/15 19:51
 */
public class Main3 {
    private final static String target = "HelloCiscol";
    private final static String target2 = "Hello Ciscol";
    private final static String str1 = "HelloCiscol";
    private final static String str2 = "Hello"+ "Ciscol";
    private final static String str3 = target.trim();
    private final static String str4 = target2.trim();
    public static  String getString(){
        return "HelloCiscol";
    }
    public static void main(String[] args) {
        System.out.println((target == str1) ? "true" : "false");
        System.out.println((target == str2) ? "true" : "false");
        System.out.println((target == str3) ? "true" : "false");
        System.out.println((target == str4) ? "true" : "false");
        System.out.println((target == getString()) ? "true" : "false");
    }
}
