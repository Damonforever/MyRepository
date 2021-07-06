package treeCode;

public class Solution_isValidBST {
    public boolean isValidBST(TreeNode root) {
        return recure(root,null,null);
    }
    boolean recure(TreeNode root,TreeNode min,TreeNode max){
        if(root == null){
            return true;
        }
        if (min != null && root.val <= min.val){
            return false;
        }
        if(max != null && root.val >= max.val){
            return false;
        }
        return recure(root.left,min,root) && recure(root.right,root,max);
    }
}
