package linkedlistCode;

public class Solution_removeElements {
    public ListNode3 removeElements(ListNode3 head, int val) {
        ListNode3 list = head;
        while(head!=null){
            while(list.next!=null && list.val==val){
                list=list.next;
            }
            if(head.val==val){
                head=head.next;
            }
        }
        return list;
    }
}
