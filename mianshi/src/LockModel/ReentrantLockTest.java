package LockModel;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 可重入锁
 * @author: Damon
 * @date 2021/8/13 10:16
 */
public class ReentrantLockTest {
    private static ReentrantLock lock = new ReentrantLock();
    public static void BookSeat(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始卖票");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "卖出票");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> BookSeat()).start();
        new Thread(() -> BookSeat()).start();
        new Thread(() -> BookSeat()).start();
        new Thread(() -> BookSeat()).start();
        new Thread(() -> BookSeat()).start();

    }
}
