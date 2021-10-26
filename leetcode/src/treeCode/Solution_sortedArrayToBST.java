package treeCode;

/**
 * @description: 有序数组转搜索二叉树
 * @author: Damon
 * @date 2021/10/26 21:00
 */
public class Solution_sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = (nums.length - 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(0,mid - 1,nums);
        root.right = helper(mid + 1, nums.length - 1,nums);
        return root;
    }
    static TreeNode helper(int left, int right, int[] nums){
        if (left <= right){
            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(left,mid - 1,nums);
            root.right = helper(mid + 1, right,nums);
            return root;
        }
        return null;
    }
}
