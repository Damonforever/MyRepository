package linkedlistCode;

/**
 * @description: 反转链表前N个节点
 * @author: Damon
 * @date 2021/8/6 14:06
 */
public class Solution_reverseN {
    //记录后驱节点
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
}
