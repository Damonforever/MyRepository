package linkedlistCode;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/4 22:19
 */
public class Solution_reorderList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        reorderList(node);
    }
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        //找中点
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode node = slow;
        slow = slow.next;
        node.next = null;
        //反转后半截
        fast = null;
        while (slow != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = slow;
            slow = temp;
        }
        //组合
        ListNode newNode = head;
        while (fast != null){
            ListNode temp = newNode.next;
            ListNode temp1 = fast.next;
            newNode.next = fast;
            fast.next = temp;
            newNode = temp;
            fast = temp1;
        }
    }
}
