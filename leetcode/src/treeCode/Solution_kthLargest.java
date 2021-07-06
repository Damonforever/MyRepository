package treeCode;

import java.util.ArrayList;
import java.util.Stack;

public class Solution_kthLargest {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(2);
        a.left = b;
        a.right = c;
        b.right = d;
        System.out.println(kthLargest(a,1));
    }

    static int kthLargest(TreeNode root, int k) {
        int count = 0;
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        midOrder(root,treeNodes);
        return treeNodes.get(treeNodes.size()-k).val;
    }

    static void midOrder(TreeNode biTree, ArrayList<TreeNode> list){

        if(biTree == null){
            return;
        }else{
            midOrder(biTree.left,list);
            list.add(biTree);
            midOrder(biTree.right,list);
        }
    }

}
