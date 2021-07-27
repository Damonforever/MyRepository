package linkedlistCode;

public class Solution_mergeTwoLists {
    public static void main(String[] args) {

    }

    public ListNode3 mergeTwoLists(ListNode3 l1, ListNode3 l2) {
        ListNode3 prehead = new ListNode3(-1);

        ListNode3 prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if(l1 == null){
            prev.next = l2;
        }else{
            prev.next = l1;
        }
        return prehead.next;
    }

























    public ListNode3 mergeTwoLists1(ListNode3 l1, ListNode3 l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode3 root = new ListNode3(0);
        ListNode3 tmp = root;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                tmp.next = l2;
                l2 = l2.next;

            }else{
                tmp.next = l1;
                l1 = l1.next;
            }
            tmp = tmp.next;
        }
        if (l1 == null) tmp.next = l2;
        else  tmp.next = l1;
        return root;
    }
}
