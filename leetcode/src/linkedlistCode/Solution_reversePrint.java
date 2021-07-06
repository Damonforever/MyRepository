package linkedlistCode;

import java.util.ArrayList;
import java.util.Arrays;

/*
* 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
示例 1：
输入：head = [1,3,2]
输出：[2,3,1]
限制：
0 <= 链表长度 <= 10000
* */
public class Solution_reversePrint {

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    static int[] reversePrint(ListNode head){
//        ArrayList<Integer> num = new ArrayList<>();
//        if(head!=null){
//            while(head.next!=null){
//                num.add(0,head.val);
//                head=head.next;
//            }
//            num.add(0,head.val);
//            int len = num.size()-1;
//            int temp = 0;
//            int m=0;
//            int[] number = num.stream().mapToInt(Integer::intValue).toArray();
//            while(m<len){
//                temp= number[m];
//                number[m]= number[len];
//                number[len] = temp;
//                len--;
//                m++;
//            }
//            return number;
//        }else{
//            int[] test = {};
//            return test;
//        }
        ArrayList<Integer> num = new ArrayList<>();
        if(head!=null){
            while(head.next!=null){
                num.add(head.val);
                head=head.next;
            }
            num.add(head.val);
            int len = num.size()-1;
            int[] number = new int[num.size()];
            for(int temp: num){
                number[len]=temp;
                len--;
            }
            return number;
        }else{
            int[] test = {};
            return test;
        }

    }

}
