package linkedlistCode;

public class Solutiong_hasCycle {
    public boolean hasCycle(ListNode1 head) {
        boolean flag = false;
        ListNode1 fast = head;
        ListNode1 slow = head;
        if(head!=null && head.next.next!=null){
            fast = head.next.next;
            slow = head.next;
        }
        while (fast != null && fast.next!=null && fast.next.next != null && !flag) {
            fast = fast.next.next;
            slow = slow.next;
            if( fast.next!=null && fast.next.next != null){
                if (fast != slow ) {
                    fast = fast.next.next;
                    slow = slow.next;
                }else{
                    flag=true;
                }
            }
        }
        return flag;
    }
}
