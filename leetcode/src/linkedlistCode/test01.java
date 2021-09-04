package linkedlistCode;

import java.util.*;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/31 19:25
 */
public class test01 {
//    public ListNode1 remove_duplicate (ListNode1 head) {
//        // write code here
//        if (head == null) return null;
//        ListNode1 newhead = new ListNode1(0);
//        newhead.next = head;
//        ListNode1 cur = head;
//        ListNode1 pre = newhead;
//        HashSet<Integer> set = new HashSet<>();
//        HashSet<Integer> set1 = new HashSet<>();
//        while (cur != null){
//            if (!set.add(cur.val)){
//                set1.add(cur.val);
//            }
//            cur = cur.next;
//        }
//        while (pre.next != null){
//            while (pre.next != null && set1.contains(pre.next.val)){
//                pre.next = pre.next.next;
//            }
//            pre = pre.next;
//        }
//    }
    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(2);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        System.out.println(remove_duplicate(node1));
        System.out.println(get_pair_count(new int[]{1,3,2,0}));
    }
    public static ListNode remove_duplicate (ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode cur = head;
        ListNode pre = cur;
        while (cur != null){
            if (set.contains(cur.val)){
                pre.next = cur.next;
            }else {
                set.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
    public static int get_pair_count (int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + 1 == arr[i + 1]){
                count++;
            }
        }
        return count;
    }
    public int countSubstr (String s, String t) {
        // write code here
        int m = s.length();
        int n = t.length();
        int count = 0;
        for (int i = -m + 1; i < n; i++) {
            int k = 0, j = 0;
            if (i > 0){
                j = i;
            }else {
                k = -i;
            }
            int f = 0, g = 0;
            for (; k < m && j < n; ++k,++j){
                if (s.charAt(k) == t.charAt(j)){
                    g++;
                }else {
                    f = g + 1;
                    g = 0;
                }
                count += f;
            }
        }
        return count;
    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
