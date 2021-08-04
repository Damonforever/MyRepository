package ProducerConsumerCode;

import java.util.Queue;
import java.util.Random;

/**
 * @description: 生产者消费者模式：使用Object.wait() / notify()方法实现
 * @author: Damon
 * @date 2021/8/4 17:07
 */
public class ProducerConsumer {
    private static final int capacity = 5;

    public static void main(String[] args) {

    }
    //生产者
    public static class Producer extends Thread{
        private Queue<Integer> queue;
        String name;
        int maxSize, i = 0;
        public Producer(String name, Queue<Integer> queue, int maxSize){
            super(name);
            this.name = name;
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true){
                synchronized (queue){
                    while (queue.size() == maxSize){
                        try {
                            System.out .println("Queue is full, Producer[" + name + "] thread waiting for " + "consumer to take something from queue.");
                            queue.wait();
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }

                    System.out.println("[" + name + "] Producing value : +" + i);
                    queue.offer(i++);
                    queue.notifyAll();

                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //消费者
    public static class Consumer extends Thread {
        private Queue<Integer> queue;
        String name;
        int maxSize;

        public Consumer(String name, Queue<Integer> queue, int maxSize) {
            super(name);
            this.name = name;
            this.queue = queue;
            this.maxSize = maxSize;
        }
        @Override
        public void run(){
            while(true){
                synchronized(queue){
                    while(queue.isEmpty()){
                        try {
                            System.out.println("Queue is empty, Consumer[" + name + "] thread is waiting for Producer");
                            queue.wait();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    int x = queue.poll();
                    System.out.println("[" + name + "] Consuming value : " + x);
                    queue.notifyAll();

                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
