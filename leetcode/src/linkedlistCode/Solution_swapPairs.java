package linkedlistCode;

/**
 * @description: 两两交换链表
 * @author: Damon
 * @date 2021/7/5 20:08
 */
public class Solution_swapPairs {
    public static void main(String[] args) {
        ListNode2 node1 = new ListNode2(1);
        ListNode2 node2 = new ListNode2(2);
        ListNode2 node3 = new ListNode2(3);
        ListNode2 node4 = new ListNode2(4);
        ListNode2 node5 = new ListNode2(5);
        ListNode2 node6 = new ListNode2(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node6;
        ListNode2 res = swapPairs(node1);
//        ListNode2 temp = res.next;
        while (res != null){
            System.out.println(res.val);
            res = res.next;

        }
    }
    public static ListNode2 swapPairs(ListNode2 head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode2 temp = head, next = head;
        return change(head,temp,next);
    }
    static ListNode2 change(ListNode2 head,ListNode2 temp, ListNode2 next){
        if (head == null) return null;
        if (head.next == null) return head;
        next = head.next;
        temp = head;
        temp.next = head.next.next;
        next.next = temp;
        temp.next = change(temp.next,temp,next);
        return next;
    }
}
