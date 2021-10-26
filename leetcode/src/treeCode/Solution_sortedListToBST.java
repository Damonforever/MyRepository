package treeCode;

import java.util.ArrayList;

/**
 * @description: 有序链表转二叉搜索树
 * @author: Damon
 * @date 2021/10/26 21:43
 */
public class Solution_sortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        return helper(0,list.size() - 1,list);
    }
    static TreeNode helper(int left,int right,ArrayList<Integer> list){
        if (left <= right){
            int mid = (left + right) /2;
            TreeNode root = new TreeNode(list.get(mid));
            root.left = helper(left,mid - 1,list);
            root.right = helper(mid + 1, right,list);
            return root;
        }
        return null;
    }
}
