package linkedlistCode;

public class Solution_getIntersectionNode {

    public ListNode1 getIntersectionNode(ListNode1 headA, ListNode1 headB) {
        ListNode1 A = headA;
        ListNode1 B = headB;
        boolean flag=true;
        boolean flage1 = true;
        if(A!=null || B!=null){
            while(A!=B){
                if(A!=null){
                    A=A.next;
                }else {
                    if (flag){
                        A=headB;
                        flag=false;
                    }else {
                        break;
                    }
                }
                if(B!=null){
                    B=B.next;
                }else{
                    if(flage1){
                        B=headA;
                        flage1=false;
                    }else {
                        break;
                    }
                }
            }
        }else{
            B=null;
        }
        return B;

    }
}
