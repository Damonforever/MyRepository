package linkedlistCode.LRUCode;

import java.util.LinkedHashMap;

/**
 * @description: 使用LinkedHashMap
 * @author: Damon
 * @date 2021/7/27 10:29
 */
public class LRUCache2 {
    int cap;
    LinkedHashMap<Integer,Integer> cache = new LinkedHashMap<>();
    public LRUCache2(int capacity){
        this.cap = capacity;
    }
    //提升为最近使用
    private void makeRecently(int key){
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key,val);
    }
    public int getKey(int key){
        if (!cache.containsKey(key)) return -1;
        makeRecently(key);
        return cache.get(key);
    }
    public void putKey(int key, int val){
        if (cache.containsKey(key)){
            cache.put(key,val);
            makeRecently(key);
            return;
        }
        if (cache.size() >= this.cap){
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key,val);
    }
}
