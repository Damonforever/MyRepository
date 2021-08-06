package linkedlistCode;

public class Solution_reverseList {
    public ListNode3 reverseList(ListNode3 head) {
        ListNode3 node = null;
        if(head!=null){
            while(head.next!=null){
                ListNode3 next = head.next;
                head.next=node;
                node=head;
                head=next;
            }
            head.next=node;
        }
        return head;
    }
    //纯递归
    public ListNode3 reverseList1(ListNode3 head) {
        if (head == null || head.next == null) return head;
        ListNode3 newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
