package ParallelMode.PCModel;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/27 14:44
 */
public class Producer implements Runnable{
    private volatile boolean isRunning = true;
    private BlockingQueue<PCData> queue;
    private static AtomicInteger count = new AtomicInteger();
    private static final int SLEEP_TIME = 1000;
    public Producer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        PCData data = null;
        Random r = new Random();
        System.out.println("start producer id=" + Thread.currentThread().getId());
        try {
            while (isRunning){
                Thread.sleep(r.nextInt(SLEEP_TIME));
                data = new PCData(count.incrementAndGet());//构造任务数据
                System.out.println(data + " is put into queue");
                if (!queue.offer(data,2, TimeUnit.SECONDS)){
                    System.out.println("failed to put data: " + data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
    public void stop(){
        isRunning = false;
    }
}
