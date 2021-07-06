package treeCode;

import java.util.ArrayList;
import java.util.List;

public class Solution_inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        boolean flag = true;
        
        if(root.left != null){
            flag = false;
        }
        while(root != null){
            if(root.right !=null){
                list1.add(root.val);
            }
            if(root.left != null){
                list2.add(root.val);
            }
            if(root.left == null && root.right != null){
                root = root.right;
            }else if(root.right == null && root.left != null){
                root = root.left;
            }else {
                break;
            }
        }
        if(list1.size() < list2.size()){
            list1.add(root.val);
        }else if(list2.size() < list1.size()){
            list2.add(root.val);
        }else {
            if (flag){
                list1.add(root.val);
            }else {
                list2.add(root.val);
            }

        }
        if(!list2.isEmpty()){
            for(Integer s: list2){
                list1.add(s);
            }
        }
        return list1;
    }

}
