package linkedlistCode;

import java.util.HashMap;
import java.util.Map;

public class Solution_copyRandomList {
    public Node copyRandomList(Node head) {
//        Node prehead = new Node(0);
//        Node node = head;
//        prehead.next = node;
//        if(head == null){
//            return prehead.next;
//        }
//
//        while (head.next != null){
//            node.next = head.next;
//            node.random = head.random;
//            node = node.next;
//            head = head.next;
//        }
//        node.next = head.next;
//        node.random = head.random;
//        return prehead.next;
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
}
