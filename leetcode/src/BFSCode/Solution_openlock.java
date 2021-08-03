package BFSCode;

import java.util.*;

/**
 * @description: 打开转盘锁
 * @author: Damon
 * @date 2021/8/2 10:59
 */
public class Solution_openlock {
    //传统bfs
    public int openLock(String[] deadends, String target) {
        //记录需要跳过的死亡密码
        HashSet<String> deads = new HashSet();
        deads.addAll(Arrays.asList(deadends));
        //记录已经穷举的密码，防止走回头路
        Set<String> visited = new HashSet();
        Queue<String> queue = new LinkedList<>();
        //从起点开始启动广度优先搜索
        int step = 0;
        queue.offer("0000");
        visited.add("0000");

        while (!queue.isEmpty()){
            int sz = queue.size();
            //将当前的所有节点向周围扩散
            for (int i = 0; i < sz; i++) {
                String cur = queue.poll();
                //判断当前密码是否合法，是否达到终点
                if (deads.contains(cur)) continue;
                if (cur.equals(target)) return step;
                //将一个节点的未遍历相邻节点加入队列
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur,j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur,j);
                    if (!visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    //双向bfs
    public int openLock1(String[] deadends, String target) {
        //记录需要跳过的死亡密码
        HashSet<String> deads = new HashSet();
        deads.addAll(Arrays.asList(deadends));
        //用集合不用队列，快速判断元素是否存在
        Set<String> q1 = new HashSet();
        Set<String> q2 = new HashSet();
        Set<String> visited = new HashSet();
        //初始化起点和终点
        int step = 0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()){
            //在遍历时不能修改哈希集合
            //用temp存储q1的扩散结果
            Set<String> tempQ = new HashSet<>();

            //将q1中所有节点向周围扩散
            for (String cur : q1) {
                //判断是否到达终点
                if (deads.contains(cur)) continue;
                if (q2.contains(cur)) return step;
                visited.add(cur);
                //将一个节点的未遍历相邻节点加入集合
                for (int i = 0; i < 4; i++) {
                    String up = plusOne(cur,i);
                    if (!visited.contains(up)) tempQ.add(up);
                    String down = minusOne(cur,i);
                    if (!visited.contains(down)) tempQ.add(down);
                }
            }
            step++;
            //tempQ相当于q1
            //在这里交换q1和q2,下一轮扩散q2
            q1 = q2;
            q2 = tempQ;
        }
        return -1;
    }

    //将s[j]向上拨一次
    static String plusOne(String s,int j){
        char[] ch = s.toCharArray();
        if (ch[j] == '9') ch[j] = '0';
        else ch[j] += 1;
        return new String(ch);
    }
    //将s[j]向下拨一次
    static String minusOne(String s, int j){
        char[] ch = s.toCharArray();
        if (ch[j] == '0') ch[j] = '9';
        else ch[j] -= 1;
        return new String(ch);
    }
}
