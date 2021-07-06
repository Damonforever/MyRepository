package linkedlistCode;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/5 21:20
 */
public class Solution_addTwoNumbers {
    public ListNode2 addTwoNumbers(ListNode2 l1, ListNode2 l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int carry = 0;
        return getSum(l1,l2,carry);

    }
    static ListNode2 getSum(ListNode2 l1, ListNode2 l2, int carry){
        if (l1 == null && l2 == null){
            if (carry == 0) return null;
            return new ListNode2(carry);
        }
        if (l1 == null){
            if ( carry == 0) return l2;
            int sum = l2.val + carry;
            carry = 0;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            }
            l2.val = sum;
            l2.next = getSum(null,l2.next,carry);
            return l2;
        }
        if (l2 == null){
            if (carry == 0) return l1;
            int sum = l1.val + carry;
            carry = 0;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            }
            l1.val = sum;
            l1.next = getSum(null,l1.next,carry);
            return l1;

        }
        int sum = l1.val + l2.val + carry;
        carry = 0;
        if (sum >= 10) {
            sum = sum % 10;
            carry = 1;
        }
        l1.val = sum;
        l1.next = getSum(l1.next,l2.next,carry);
        return l1;
    }
}
