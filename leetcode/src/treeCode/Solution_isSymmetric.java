package treeCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_isSymmetric {
    //左右开弓
    public boolean isSymmetric(TreeNode root) {
        if(root != null){
            TreeNode lroot = root;
            Stack<TreeNode> stackl = new Stack<>();
            Stack<TreeNode> stackr = new Stack<>();
            while((root != null && lroot != null) || (!stackl.isEmpty() && !stackr.isEmpty())){
                while(lroot != null || root != null){
                    if(lroot != null && root == null){
                        return false;
                    }
                    if(lroot == null && root != null){
                        return false;
                    }
                    stackl.push(lroot);
                    lroot = lroot.left;
                    stackr.push(root);
                    root = root.right;
                }
                if(!stackl.isEmpty() && !stackr.isEmpty()){
                    lroot = stackl.pop();
                    root = stackr.pop();
                    if(lroot.val != root.val){
                        return false;
                    }
                    if(lroot == root){
                        return true;
                    }
                    lroot = lroot.right;
                    root = root.left;
                }
            }
            return true;
        }else {
            return true;
        }
    }

    /*
    * 有bug，一种元素相同的特殊情况会被忽略[[1,2,2,2,null,2]]
    * */
//    public boolean isSymmetric(TreeNode root) {
//        if(root != null){
//            ArrayList<Integer> list = new ArrayList<>();
//            mid(root,list);
//            int head = 0;
//            int tail = list.size() -1;
//            if(list.size() % 2 == 0){
//                return false;
//            }else{
//                while(head != tail){
//                    if(list.get(head) == list.get(tail)){
//                        head++;
//                        tail--;
//                    }else{
//                        return false;
//                    }
//                }
//                return true;
//            }
//        }else{
//            return true;
//        }
//
//    }
//    public static void mid(TreeNode treeNode,ArrayList<Integer> arrayList){
//        Stack<TreeNode> stack = new Stack<>();
//        while(treeNode != null || !stack.isEmpty()){
//            while (treeNode != null){
//                stack.push(treeNode);
//                treeNode = treeNode.left;
//            }
//            if(!stack.isEmpty()){
//                treeNode = stack.pop();
//                arrayList.add(treeNode.val);
//                treeNode = treeNode.right;
//            }
//        }
//    }
}
