package ThreadModel;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/25 22:11
 */
public class Print2 implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition1 = lock.newCondition();
    public static Condition condition2 = lock.newCondition();
    public static int i;
    @Override
    public void run() {
        while (true){
            try {
                if (Thread.currentThread().getName().equals("T1")){
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "在打印" + i);
                    i++;
                    try {
                        condition1.await();
                        condition2.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "在打印" + i);
                    i++;
                    try {
                        condition2.await();
                        condition1.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }
            if (i > 99 ) break;
        }
    }
    public static void main(String[] args) {
        print1 p1 = new print1();
        Thread t1 = new Thread(p1,"T1");
        Thread t2 = new Thread(p1,"T2");
        t1.start();
        t2.start();
    }
}
