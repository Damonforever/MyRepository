package ThreadModel;

import java.util.concurrent.*;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/11 16:48
 */
public class Thread01 {
    private static Runnable saleTicket(final int i ){
        return new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("售出第" + i + "张票");
            }
        };
    }
    public static void main(String[] args) {
//        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 100, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < 10; i++) {
//            executorService.execute(saleTicket(i));
//        }
//        //必须写shutdown方法，线程池不会主动，释放资源
//        executorService.shutdown();

//        ExecutorService executorService1 = Executors.newCachedThreadPool();
//        for (int i = 0; i < 10; i++) {
//            executorService1.execute(saleTicket(i));
//        }
//        //如果不写shutdown方法，线程池会在线程空闲60秒后杀死线程
//        executorService1.shutdown();

//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(4000);
//                    System.out.println(Thread.currentThread().getId() + "执行了");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },0,2,TimeUnit.SECONDS);


//        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 30; i++) {
//            executorService2.execute(saleTicket(i));
//        }
        //必须写shutdown方法，线程池不会主动，释放资源
//        executorService2.shutdown();


//        TicketSale ticketSale = new TicketSale();
//
//        Thread Sale1 = new Thread(ticketSale, "售票口1");
//        Thread Sale2 = new Thread(ticketSale, "售票口2");
//        Thread Sale3 = new Thread(ticketSale, "售票口3");
//        Thread Sale4 = new Thread(ticketSale, "售票口4");
//        // 启动线程，开始售票
//        Sale1.start();
//        Sale2.start();
//        Sale3.start();
//        Sale4.start();

//        MyThread myThread1 = new MyThread("线程1");
//        MyThread myThread2 = new MyThread("线程2");
//        MyThread myThread3 = new MyThread("线程3");
//        MyThread myThread4 = new MyThread("线程4");
//        myThread1.start();
//        myThread2.start();
//        myThread3.start();
//        myThread4.start();



    }
}
class TicketSale implements Runnable {
    int ticketSum = 100;

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 有余票，就卖
        while (ticketSum > 0) {
            System.out.println(Thread.currentThread().getName() + "售出第" + (100 - ticketSum + 1) + "张票");
            ticketSum--;
        }
        System.out.println(Thread.currentThread().getName() + "表示没有票了");
    }
}
class MyThread extends Thread{
   static int ticketSum = 10;
    String name;

    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 有余票，就卖
        while (ticketSum > 0) {
            System.out.println(name + "售出第" + (10 - ticketSum + 1) + "张票");
            ticketSum--;
        }
        System.out.println(name + "表示没有票了");
    }
}
