package treeCode;

import java.util.HashMap;

public class test {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return helper(preorder, 0,preorder.length - 1,inorder,0,inorder.length - 1,map);
    }
    static TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map){
        if (preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int num = map.get(preorder[preStart]);
        int temp = num - inStart;
        root.left = helper(preorder, preStart + 1, preStart +temp, inorder, inStart,num -1, map);
        root.right = helper(preorder,preEnd + temp + 1, preEnd, inorder,num + 1, inEnd, map);
        return root;
    }
}
