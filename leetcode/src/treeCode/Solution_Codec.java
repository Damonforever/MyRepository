package treeCode;

import java.util.LinkedList;

public class Solution_Codec {
    String SEP = ",";
    String NULL = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    void serialize(TreeNode root,StringBuilder stringBuilder){
        if(root == null){
            stringBuilder.append(NULL).append(SEP);
            return;
        }
        stringBuilder.append(root.val).append(SEP);
        serialize(root.left,stringBuilder);
        serialize(root.right,stringBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }
    TreeNode deserialize(LinkedList<String> nodes){
        if (nodes.isEmpty()) return null;
        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}
