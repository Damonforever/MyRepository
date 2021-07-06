package treeCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution_levelOrder {
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
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        int count = 0;
        if(root != null){
            deque.add(root);
            count++;
            List<List<Integer>> array = new ArrayList<>();
            while(!deque.isEmpty()){
                List<Integer> list = new ArrayList<>();
                List<TreeNode> list1 = new ArrayList<>();
                while(count != 0){
                    list.add(deque.peek().val);
                    list1.add(deque.poll());
                    count--;
                }
                for (TreeNode num : list1){
                    if(num.left != null){
                        deque.add(num.left);
                        count++;
                    }
                    if (num.right != null){
                        deque.add(num.right);
                        count++;
                    }
                }
                array.add(list);
            }
            return array;

        }else {
            ArrayList<List<Integer>> array = new ArrayList<>();
            return array;
        }
    }
}
