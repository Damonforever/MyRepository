package treeCode;

public class Solution_mirrorTree {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        a.left = b;
        a.right = null;
        b.left = c;
        b.right = null;
        System.out.println(mirrorTree(a).right.val);
    }

    static TreeNode mirrorTree(TreeNode root) {

        if(root != null){
            //TreeNode node = root;
            if(root.left != null && root.right != null){
                TreeNode tree = root.left;
                root.left = root.right;
                root.right = tree;
                mirrorTree(root.left);
                mirrorTree(root.right);
            }else{
                if(root.left == null && root.right != null){
                    root.left = root.right;
                    root.right = null;
                    mirrorTree(root.left);
                }else if(root.right == null && root.left != null){
                    root.right = root.left;
                    root.left = null;
                    mirrorTree(root.right);
                }
            }
        }
        return root;
    }
}
