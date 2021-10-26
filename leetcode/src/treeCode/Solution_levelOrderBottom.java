package treeCode;

import java.util.*;

/**
 * @description: 二叉树层次遍历2
 * @author: Damon
 * @date 2021/10/26 20:22
 */
public class Solution_levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Deque<List<Integer>> result = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            result.addFirst(list);
        }
        return new LinkedList<>(result);
    }
}
