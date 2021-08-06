package linkedlistCode;

/**
 * @description: 反转链表的一部分
 * @author: Damon
 * @date 2021/8/6 14:38
 */
public class Solution_reverseBetween {
    ListNode3 successor = null;
    ListNode3 reverseN (ListNode3 head, int n){
        if (n == 1) {
            successor = head.next;
            return head;
        }
        //以head.next为起点，反转前n-1个
        ListNode3 newHead = reverseN(head.next, n - 1);
        head.next.next = head;
        //反转之后的head节点和后面的节点连接起来
        head.next = successor;
        return newHead;
    }
    ListNode3 reverseBetween(ListNode3 head,int m, int n){
        if (m == 1) return reverseN(head,n);
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}
