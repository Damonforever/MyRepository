package linkedlistCode.LRUCode;

import java.util.HashMap;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/27 10:00
 */
public class LRUCache {
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    //最大容量
    private int cap;
    public LRUCache(int capacity){
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    //将某个key提升为最近使用的
    private void makeRecently(int key){
        Node x = map.get(key);
        //删除此节点
        cache.remove(x);
        //添加到队尾
        cache.addLast(x);
    }
    //添加最近使用的元素
    private void addRecently(int key,int val){
        Node x = new Node(key,val);
        //链表中需要加
        cache.addLast(x);
        //map中也需要加
        map.put(key,x);
    }
    //删除某一个key
    private void deleteKey(int key){
        Node x = map.get(key);
        map.remove(key);
        cache.remove(x);
    }
    //删除最久未使用元素
    private void removeLeastRecently(){
        //链表头部是最久未使用的
        Node x = cache.removeFirst();
        map.remove(x.key);
    }
    //get方法
    public int get(int key){
        if (!map.containsKey(key)) return -1;
        makeRecently(key);
        return map.get(key).val;
    }
    //put方法
    public void put(int key, int val){
        if (map.containsKey(key)){
            //删除旧的
            deleteKey(key);
            //插入新的
            addRecently(key, val);
            return;
        }
        if (cap == cache.size()) removeLeastRecently();
        addRecently(key, val);
    }
}
