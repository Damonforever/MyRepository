package treeCode;

import java.util.HashMap;
import java.util.Map;

public class Solution_buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i],i);
        }
        return recure(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inmap);
    }
    public TreeNode recure(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,Map<Integer,Integer> inmap){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inmap.get(root.val);
        int numsLeft = inRoot - inStart;
        root.left = recure(preorder,preStart + 1,preStart + numsLeft, inorder,inStart,inRoot - 1, inmap);
        root.right = recure(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot +1, inEnd, inmap);
        return root;
    }
}
