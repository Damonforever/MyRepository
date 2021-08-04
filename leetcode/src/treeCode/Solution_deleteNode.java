package treeCode;

/**
 * @description: 删除二叉搜索树中的节点
 * @author: Damon
 * @date 2021/8/4 10:36
 */
public class Solution_deleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key){
            //情况1：被查找节点正好是末端节点，直接删除
            //情况2：被查找节点只有一个非空子节点，让孩子节点代替自己
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            //情况3：待删除节点有两个非空子节点，必须用左子树中最大的节点或者右子树中最小的节点代替自己
            TreeNode minNode = getMinNode(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }else if (root.val > key){
            root.left = deleteNode(root.left, key);
        }else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    TreeNode getMinNode(TreeNode node){
        while(node.left != null) node = node.left;
        return node;
    }
}
