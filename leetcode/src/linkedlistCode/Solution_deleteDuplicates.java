package linkedlistCode;

public class Solution_deleteDuplicates {
    public ListNode3 deleteDuplicates(ListNode3 head) {
        ListNode3 newhead = head;
        if(head!=null){
            while(head.next!=null){
                ListNode3 list = head.next;
                if(head.val==list.val){
                    head.next=list.next;
                }
                if(head.next!=null && head.val!=head.next.val){
                    head=head.next;
                }

            }
        }
        return newhead;
    }
}
