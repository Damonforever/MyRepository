package linkedlistCode;

public class Solution_getKthFromEnd {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        int count = 1;
        ListNode node = head;
        while(head.next!=null){
            head=head.next;
            count++;
        }
        for(int i = 1; i<=count-k;i++){
            node=node.next;
        }

        return node;
    }
}
