package linkedlistCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/5 20:04
 */
public class Solution_tengxun {
    public ListNode solve (ListNode[] a) {
        // write code here

        List<ListNode> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null){
                list.add(a[i]);
            }
        }
        ListNode node = new ListNode(0);
        ListNode newNode = node;
        node.next = null;
        while (list.size() != 0){
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null){
                    node.next = list.get(i);
                    node = node.next;
                    list.set(i,list.get(i).next);
                }else {
                    list.remove(i);
                    i--;
                }
            }
        }
        return newNode.next;
    }
}
