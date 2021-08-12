package linkedlistCode;

import java.util.HashMap;
import java.util.Map;

public class Solution_copyRandomList {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
    }
    public Node copyRandomList1(Node head) {
        if (head == null) return head;
        Node newHead = new Node(head.val);
        Node temp = new Node(0), pre = head, cur = head,curHead = newHead;
        temp.next = newHead;
        while (pre.next != null){
            newHead.next = new Node(pre.next.val);
            pre = pre.next;
            newHead = newHead.next;
        }
        newHead.next = null;
        while (cur.next != null){
            if (cur.random == null){
                curHead.random = null;
            }else {
                int value = cur.random.val;
                Node index = temp.next;
                while (index.val != value){
                    index = index.next;
                }
                curHead.random = index;
            }
            curHead = curHead.next;
            cur = cur.next;
        }
        int value = cur.random.val;
        Node index = temp.next;
        while (index.val != value){
            index = index.next;
        }
        curHead.random = index;
        return temp.next;
    }
}
