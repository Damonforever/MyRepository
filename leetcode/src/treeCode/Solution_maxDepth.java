package treeCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_maxDepth {
    public int maxDepth(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        int count = 0;
        if(root != null){
            queue.add(root);
            count++;
        }
        while(!queue.isEmpty()) {
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                    if(!flag){
                        count++;
                        flag = true;
                    }

                }
                if(node.right != null) {
                    queue.add(node.right);
                    if(!flag){
                        count++;
                        flag = true;
                    }
                }
            }
            flag = false;
        }
        return count;
    }
}
