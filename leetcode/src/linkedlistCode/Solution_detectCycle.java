package linkedlistCode;

/**
 * @description: 链表中环的入口节点
 * @author: Damon
 * @date 2021/8/2 20:52
 */
public class Solution_detectCycle {
    public ListNode1 detectCycle(ListNode1 head) {
        ListNode1 fast,slow;
        fast = slow = head;
        boolean flag = false;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        if (!flag) return null;
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
