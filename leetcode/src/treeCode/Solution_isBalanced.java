package treeCode;

public class Solution_isBalanced {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return recur(root) != -1;
        }

        private int recur(TreeNode root) {
            if (root == null) return 0;
            int left = recur(root.left);
            if(left == -1) return -1;
            int right = recur(root.right);
            if(right == -1) return -1;
            return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
        }
    }
//    public boolean isBalanced(TreeNode root) {
//        if(root == null || (root.right == null && root.left == null)){
//            return true;
//        }else if (root.right == null && root.left != null){
//            if(root.left.left != null || root.left.right !=null){
//                return false;
//            }else {
//                return true;
//            }
//        }else if (root.left == null && root.right != null){
//            if(root.right.right != null || root.right.left != null){
//                return false;
//            }else {
//                return true;
//            }
//        }else {
//            if (isBalanced(root.left) && isBalanced(root.right)){
//                if(root.right.right == null && root.right.left == null){
//                    if(root.left.left != null){
//                        if(root.left.left.left != null || root.left.left.right != null){
//                            return false;
//                        }
//                    }
//                    if (root.left.right != null){
//                        if (root.left.right.left != null || root.left.right.right != null){
//                            return false;
//                        }
//                    }
//                }
//                if (root.left.right == null && root.left.left == null){
//                    if(root.right.left != null){
//                        if(root.right.left.left != null || root.right.left.right != null){
//                            return false;
//                        }
//                    }
//                    if (root.right.right != null){
//                        if (root.right.right.left != null || root.right.right.right != null){
//                            return false;
//                        }
//                    }
//                }
//                return true;
//            }
//            return false;
//        }
//    }
}
