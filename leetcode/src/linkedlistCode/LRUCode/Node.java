package linkedlistCode.LRUCode;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/27 9:38
 */
public class Node {
    public int key, val;
    public Node next, prev;
    public Node(int k, int v){
        this.key = k;
        this.val = v;
    }
}
