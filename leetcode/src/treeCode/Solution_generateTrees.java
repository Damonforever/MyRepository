package treeCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 不同的二叉搜索树
 * @author: Damon
 * @date 2021/10/27 16:11
 */
public class Solution_generateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return helper(1,n);
    }
    public List<TreeNode> helper(int left,int right){
        List<TreeNode> result = new ArrayList<>();
        if (left > right){
            result.add(null);
            return result;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTree = helper(left,i-1);
            List<TreeNode> rightTree = helper(i+1,right);
            for (TreeNode leftNode : leftTree) {
                for (TreeNode rightNode : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
