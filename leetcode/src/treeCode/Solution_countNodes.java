package treeCode;

/**
 * @description: 完全二叉树的节点个数
 * @author: Damon
 * @date 2021/8/4 14:15
 */
public class Solution_countNodes {
    public int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        int hl = 0, hr = 0;
        while (l != null){
            l = l.left;
            hl++;
        }
        while (r != null){
            r = r.right;
            hr++;
        }
        //如果左右一样高则是一颗满二叉树
        if (hl == hr) return (int) Math.pow(2,hr) - 1;
        //左右不一样高则按普通二叉树计算
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
