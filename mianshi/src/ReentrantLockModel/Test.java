package ReentrantLockModel;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/19 20:37
 */
public class Test {
    //private static ReentrantLock lock = new ReentrantLock();
    private static DamonLock lock = new DamonLock();
    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            drawMoney();
            lock.unlock();
        },"线程1").start();

        new Thread(() -> {
            lock.lock();
            drawMoney();
            lock.unlock();
        },"线程2").start();

        new Thread(() -> {
            lock.lock();
            drawMoney();
            lock.unlock();
        },"线程3").start();
    }
    private static void drawMoney(){
        System.out.println(Thread.currentThread().getName() + "正在取钱...");
        sleep(3000);
        System.out.println(Thread.currentThread().getName() + "取完了...");
    }
    private static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
