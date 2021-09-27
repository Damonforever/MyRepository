package ThreadModel;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 公平锁
 * @author: Damon
 * @date 2021/9/25 21:47
 */
public class print1 implements Runnable{
    public static ReentrantLock fairLock = new ReentrantLock(true);
    public static int i;
    @Override
    public void run() {
        while (true){
            try{
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + "在打印" + i);
                i++;
            }finally {
                fairLock.unlock();
            }
            if (i > 99) break;
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
