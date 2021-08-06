package linkedlistCode;

/**
 * @description: K 个一组翻转链表
 * @author: Damon
 * @date 2021/8/6 14:48
 */
public class Solution_reverseKGroup {
    public ListNode3 reverseKGroup(ListNode3 head, int k) {
        if (head == null) return null;
        ListNode3 a = head,b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode3 newHead = reversed(a,b);
        a.next = reverseKGroup(b,k);
        return newHead;
    }
    //反转链表
    ListNode3 reversed(ListNode3 head){
        ListNode3 pre = null,cur = head, next;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    //反转链表区间[a,b)
    ListNode3 reversed(ListNode3 a,ListNode3 b){
        ListNode3 pre = null,cur = a, next;
        while (cur != b){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
