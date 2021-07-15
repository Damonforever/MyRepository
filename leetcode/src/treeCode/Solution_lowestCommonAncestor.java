package treeCode;

import java.util.Stack;

public class Solution_lowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(6);
        TreeNode root4 = new TreeNode(2);
        TreeNode root5 = new TreeNode(0);
        TreeNode root6 = new TreeNode(8);
        TreeNode root7 = new TreeNode(7);
        TreeNode root8 = new TreeNode(4);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root2.left = root5;
        root2.right = root6;
        root4.left = root7;
        root4.right = root8;
        lowestCommonAncestor(root,root1,root8);
    }
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left == null && right == null) return null;
        if (left != null && right != null) return root;
        return left == null ? right : left;
//        Stack<TreeNode> path_p = new Stack<>();
//        Stack<TreeNode> path_q = new Stack<>();
//        int finish = 0;
//        preorder(root,p,path_p,finish);
//        finish = 0;
//        preorder(root,q,path_q,finish);
//        int len = 0;
//        if(path_p.size() < path_q.size()){
//            len = path_p.size();
//        }else {
//            len = path_q.size();
//        }
//        TreeNode result = new TreeNode(0);
//        for (int i = 0; i < len; i++) {
//            if (path_p.get(i).val == path_q.get(i).val){
//                result = path_p.get(i);
//            }
//        }
//        return result;
    }
    static int preorder(TreeNode node, TreeNode search, Stack<TreeNode> path, int finish){
        if(node == null || finish==1){
            return finish;
        }
        path.push(node);
        if (node.val == search.val){
            finish = 1;
        }
        finish = preorder(node.left,search,path,finish);
        preorder(node.right,search,path,finish);
        if(path.peek().val != search.val){
            path.pop();
        }
        return finish;
    }
}
