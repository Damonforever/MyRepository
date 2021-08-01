package InputAndOutput;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/1 10:23
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> s = new ArrayList<>();
        while (sc.hasNextInt()){
            int k = sc.nextInt();
            for (int i = 0; i < k; i++) {
                s.add(sc.next());
            }
            for (String s1 : s) {
                System.out.println(s1);
            }
            break;
//            for (int i = 0; i < k; i++) {
//                list.add(sc.nextInt());
//            }
//            System.out.println(k);
//            for (Integer num : list) {
//                System.out.println(num);
//            }

        }
//        while (sc.hasNextLine()){
//            s.add(sc.nextLine());
//            for (String s1 : s) {
//                System.out.println(s1);
//            }
//        }
//        for (int i = 0; i < 5; i++) {
//            if (sc.hasNextLine()){
//                s.add(sc.nextLine());
//            }
//        }
//        for (String s1 : s) {
//            System.out.println(s1);
//        }
//        if (sc.hasNextLine()){
//            String s1 = sc.nextLine();
//            String[] str = s1.split(" ");
//            for (String s2 : str) {
//                System.out.println(s2);
//            }
//           s.add(s1);
//        }

        sc.close();
    }
}
