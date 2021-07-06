package linkedlistCode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution_isPalindrome {
    public static void main(String[] args) {
        ListNode3 head= new ListNode3(129);
        ListNode3 node1 = new ListNode3(129);
        head.next=node1;
        node1.next=null;
        System.out.println(isPalindrome(head));
    }
    static boolean isPalindrome(ListNode3 head) {
        ListNode3 node = head;
        boolean flag = true;
        List<ListNode3> list = new ArrayList<>();
        while(head != null){
            list.add(head);
            head=head.next;
        }
        int end=list.size()-1;
        for(int i = 0;i<=list.size()/2-1;i++){
            if(list.get(i).val!=list.get(end).val){
                flag=false;
                break;
            }
            end--;
        }
        return flag;
    }
}
