package treeCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_levelorder1 {
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            int[] result = new int[0];
            return result;
        }
        ArrayList<TreeNode> num = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            num.add(node);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        int[] result = new int[num.size()];
        for (int i = 0; i < num.size(); i++) {
            result[i] = num.get(i).val;
        }
        return result;
    }
}
