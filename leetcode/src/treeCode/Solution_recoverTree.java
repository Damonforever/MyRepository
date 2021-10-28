package treeCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 恢复二叉搜索树
 * @author: Damon
 * @date 2021/10/27 19:33
 */
public class Solution_recoverTree {
    public static void main(String[] args) {

    }
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root,nums);
        int max = 0;
        int min = 0;
        for (int i = 0; i < nums.size()-1; i++) {
            if (nums.get(i) > nums.get(i+1)){
                max = nums.get(i);
                break;
            }
        }
        for (int i = nums.size()-1; i >0; i--) {
            if (nums.get(i) < nums.get(i-1)){
                min = nums.get(i);
                break;
            }
        }
        swap(root,max,min,2);
    }
    public void inorder(TreeNode root, List<Integer> nums){
        if (root == null) return;
        inorder(root.left,nums);
        nums.add(root.val);
        inorder(root.right,nums);
    }
    public void swap(TreeNode root,int max, int min,int count){
        swap(root.left,max,min,count);
        if (root.val == max || root.val == min){
            if (root.val == max){
                root.val = min;
            }else {
                root.val = max;
            }
            count--;
            if (count == 0) return;
        }
        swap(root.right, max, min,count);
    }
    public void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }
}
