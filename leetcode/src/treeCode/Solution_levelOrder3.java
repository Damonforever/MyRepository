package treeCode;

import java.util.*;

public class Solution_levelOrder3 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);
        root.left = root1;
        root.right = root2;
        root1.left = null;
        root1.right = null;
        root2.left = root3;
        root2.right = root4;
        List<List<Integer>> array = new ArrayList<>();
        array = levelOrder(root);
        for(List<Integer> li : array){
            for (Integer num : li){
                System.out.print(num + " ");
            }
            System.out.println("\n");
        }
    }
    static List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        deque.add(root);
        boolean flag = true;
        while(!deque.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--){

                if(flag){
                    TreeNode node = deque.removeFirst();
                    list.add(node.val);
                    if(node.left != null){
                        deque.addLast(node.left);
                    }
                    if(node.right != null){
                        deque.addLast(node.right);
                    }
                }else {
                    TreeNode node = deque.removeLast();
                    list.add(node.val);
                    if(node.right != null){
                        deque.addFirst(node.right);
                    }
                    if(node.left != null){
                        deque.addFirst(node.left);
                    }
                }
            }
            result.add(list);
            if(flag == true){
                flag = false;
            }else{
                flag = true;
            }
        }
        return result;
    }
}
