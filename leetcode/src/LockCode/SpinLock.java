package LockCode;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @description: 自旋锁
 * @author: Damon
 * @date 2021/7/5 16:27
 */
public class SpinLock {
    private AtomicReference<Thread> cas = new AtomicReference<Thread>();
    public void lock(){
        Thread current = Thread.currentThread();
        while (!cas.compareAndSet(null,current)){
            //DO
        }
    }
    public void unlock(){
        Thread current = Thread.currentThread();
        cas.compareAndSet(current,null);
    }
}
