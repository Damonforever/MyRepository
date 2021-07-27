package linkedlistCode.LRUCode;

/**
 * @description: 使用自己写的双向链表
 * @author: Damon
 * @date 2021/7/27 9:41
 */
public class DoubleList {
    //头和尾节点
    private Node tail, head;
    //链表元素
    private int size;

    public DoubleList(){
        //初始化双向链表
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.next = head;
        size = 0;
    }
    //在链表尾部加入节点x,时间复杂度为O(1)
    public void addLast(Node x){
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }
    //删除一定存在的节点x
    //由于是双链表，且给的是目标Node节点，时间复杂度为O(1)
    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }
    //删除链表中第一个节点，并返回该值，时间复杂度为O(1)
    public Node removeFirst(){
        if (head.next == tail) return null;
        Node first = head.next;
        remove(first);
        return first;
    }
    public int size(){
        return size;
    }
}
