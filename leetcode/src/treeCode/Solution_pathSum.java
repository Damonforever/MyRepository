package treeCode;

import java.util.LinkedList;
import java.util.List;

public class Solution_pathSum {
    LinkedList<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return result;
        }
        return preorder(root,sum);
    }
     List<List<Integer>> preorder(TreeNode root,int sum){
        if(root == null){
            if(sum == 0){
                result.add(new LinkedList<>(list));
            }
            list.remove(list.size()-1);
            return null;
        }
        list.add(root.val);
        sum -= root.val;
        preorder(root.left,sum);
        preorder(root.right,sum);
        return result;
    }
}
