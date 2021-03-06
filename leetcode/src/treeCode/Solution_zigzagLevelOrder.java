package treeCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 二叉树的锯齿形层序遍历
 * @author: Damon
 * @date 2021/9/1 21:51
 */
public class Solution_zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            if (count % 2 == 1){
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.pollLast();
                    temp.add(node.val);
                    if (node.left != null) queue.offerFirst(node.left);
                    if (node.right != null) queue.offerFirst(node.right);
                }
            }else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.pollFirst();
                    temp.add(node.val);
                    if (node.right != null) queue.offerLast(node.right);
                    if (node.left != null) queue.offerLast(node.left);
                }
            }
            result.add(temp);
            count++;
        }
        return result;
    }
}
