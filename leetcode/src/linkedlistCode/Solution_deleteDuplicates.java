package linkedlistCode;

public class Solution_deleteDuplicates {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        System.out.println(deleteDuplicates(node1));
    }
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
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode index = newHead;
        ListNode cur = head;
        if(head == null) return head;
        while(cur!= null){
            if(cur.next != null && cur.val == cur.next.val){
                while (cur.next != null && cur.val == cur.next.val){
                    index.next = cur.next;
                    cur = cur.next;
                }
                cur = cur.next;
                index.next = cur;
            }else{
                index = cur;
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}
