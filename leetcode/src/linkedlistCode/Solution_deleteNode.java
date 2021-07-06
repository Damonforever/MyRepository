package linkedlistCode;

public class Solution_deleteNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteNode(ListNode head,int val){
        ListNode temp1=head;
        ListNode temp=head.next;
        boolean flag =false;

        while(head.val!=val){
            temp=head;
            head=head.next;
            flag = true;
        }
        if(flag){
            temp.next=head.next;
        }
        if(!flag){
            temp1= temp;
            temp1.next=temp.next;
        }
        return temp1;
    }
}
