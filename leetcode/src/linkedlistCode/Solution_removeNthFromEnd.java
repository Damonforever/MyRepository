package linkedlistCode;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/5 11:28
 */
public class Solution_removeNthFromEnd {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(removeNthFromEnd(node,2).val);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(-1);
        ListNode fast = head;
        tmp.next = head;
        ListNode slow = tmp;
        int count = 1;
        while(count < n){
            fast = fast.next;
            count++;
        }
        if (fast.next == null) {
            return slow.next.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return tmp.next;
    }

}
