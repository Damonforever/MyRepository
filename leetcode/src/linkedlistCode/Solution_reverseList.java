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
}
