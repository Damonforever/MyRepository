package linkedlistCode;

public class Solution_hasCycle {
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
    public boolean hasCycle1(ListNode1 head) {
        ListNode1 fast,slow;
        fast = slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
