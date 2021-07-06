package linkedlistCode;

/**
 * @description: 链表的中间结点
 * @author: Damon
 * @date 2021/7/6 10:11
 */
public class Solution_middleNode {
    public ListNode2 middleNode(ListNode2 head) {
        ListNode2 fast, slow;
        slow = head;
        fast = head.next;
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
            if (fast != null) fast = fast.next;
        }
        return slow;

    }
}
