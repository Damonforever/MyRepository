package treeCode;

/**
 * @description: 二叉搜索树中的插入操作
 * @author: Damon
 * @date 2021/8/4 10:23
 */
public class Solution_insertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val == val) return root;
        if (root.val < val) root.right = insertIntoBST(root.right,val);
        if (root.val > val) root.left = insertIntoBST(root.left, val);
        return root;
    }
}
