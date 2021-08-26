package treeCode;

/**
 * @description: 二叉树中的最大路径和
 * @author: Damon
 * @date 2021/8/23 17:02
 */
public class Solution_maxSumPath {
    int max = 0;
    public int maxPathSum(TreeNode root) {
        return 0;
    }
    int helper(TreeNode root,int value){
        if (root.left ==null && root.right == null){
            return Math.max(root.val, 0);
        }else if (root.left !=null && root.right != null){
            int left = helper(root.left, root.val);
            int right = helper(root.right, root.val);
            int max = Math.max(left,right);
//            if (value + max > 0)
        }
        return 0;

    }
}
