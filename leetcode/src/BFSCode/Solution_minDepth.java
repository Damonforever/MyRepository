package BFSCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 树的最小深度
 * @author: Damon
 * @date 2021/8/2 10:32
 */
public class Solution_minDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()){
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) return depth;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }
}
