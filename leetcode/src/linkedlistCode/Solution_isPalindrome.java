package linkedlistCode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_isPalindrome {
    ListNode3 left;
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
    //1.拿一个栈来操作
    static boolean isPalindrome1(ListNode3 head) {
        Stack<Integer> nums = new Stack<>();
        ListNode3 temp = head;
        while (temp != null){
            nums.push(temp.val);
            temp = temp.next;
        }
        while (!nums.isEmpty()){
            if (nums.pop() != head.val) return false;
            head = head.next;
        }
        return true;
    }
    //2.递归函数的堆栈（没看懂）
     boolean isPalindrome2(ListNode3 head) {
        left = head;
        return traverse(head);
    }
    boolean traverse(ListNode3 right){
        if (right == null) return true;
        boolean res = traverse(right.next);
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }
    //3.
    boolean isPalindrome3(ListNode3 head) {
        ListNode3 slow, fast, left, right;
        slow = fast = head;
        //快慢指针找中点
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //注意划分奇偶
        if (fast != null) slow = slow.next;
        //找到中点后，开始从中点翻转链表
        left = head;
        right = reverse(slow);
        while (right != null){
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
    ListNode3 reverse(ListNode3 head){
        ListNode3 pre = null, cur = head;
        while(cur != null){
            ListNode3 temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
