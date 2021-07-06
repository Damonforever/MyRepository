package testCode;


import java.util.*;

public class test {
    static Set<String> allSorts = new HashSet<>();
    public static void main(String[] args) {
        int[] numArray = {1, 2, 3,1};
        permutation(numArray, 0, numArray.length - 1);
        for(String s:allSorts){
            System.out.println(s);
        }
    }

    static void permutation(int[] nums, int start, int end) {
        if (start == end) { // 当只要求对数组中一个数字进行全排列时，只要就按该数组输出即可
            String newNum = ""; // 为新的排列创建一个数组容器
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<=end; i++) {
                sb.append(nums[i]);
            }
            allSorts.add(sb.toString()); // 将新的排列组合存放起来
        } else {
            for (int i=start; i<=end; i++) {
                int temp = nums[start]; // 交换数组第一个元素与后续的元素
                nums[start] = nums[i];
                nums[i] = temp;
                permutation(nums, start + 1, end); // 后续元素递归全排列
                nums[i] = nums[start]; // 将交换后的数组还原
                nums[start] = temp;
            }
        }
    }
//    public static void main(String[] args) {

//        System.out.println("请输入数字：");
//        List<Integer> list = new ArrayList<>();
//        Scanner scan = new Scanner(System.in);
//
//        while (scan.hasNextInt()) {
//            int x = scan.nextInt();
//            list.add(x);
//        }
//        scan.close();
//        int m = 0;
//        int n = 0;
//        while(list.get(m) != 0){
//            int x = list.get(m);
//            if(x >= 3){
//
//            }
//        }
//        Scanner sc = new Scanner(System.in);
//        String s="";
//        if (sc.hasNext()) {
//            s = sc.next();
//        }
//        sc.close();
//        String s1="";
//        for (int i = s.length()-1; i >= 0 ; i--) {
//            s1 += s.charAt(i);
//        }
//        System.out.println(s1);

//        int num1 = 10;
//        int num2 = 20;
//        wap(num1,num2);
//        System.out.println("num1 = " + num1);
//        System.out.println("num2 = " + num2);
//    }
//    public static void wap(int a,int b){
//        int temp = a;
//        a = b;
//        b = temp;
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
//    }
}
