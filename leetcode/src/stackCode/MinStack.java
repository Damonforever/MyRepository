package stackCode;

import java.util.LinkedList;

/**
 * @description: 包含min函数的栈
 * @author: Damon
 * @date 2021/8/11 9:19
 */
public class MinStack {
    private Node node;
    private LinkedList<Node> queue = new LinkedList<>();
    public MinStack() {

    }

    public void push(int x) {
        if (queue.isEmpty()){
            node = new Node(x,x);
        }else {
            int min = Math.min(x,queue.getFirst().min);
            node = new Node(x,min);
        }

        queue.addFirst(node);
    }

    public void pop() {
        queue.removeFirst();
    }

    public int top() {
        return queue.getFirst().val;
    }

    public int min() {
        return queue.getFirst().min;
    }

    private class Node{
        int val;
        int min;
        public Node(int val,int min){
            this.val = val;
            this.min = min;
        }
    }
}
