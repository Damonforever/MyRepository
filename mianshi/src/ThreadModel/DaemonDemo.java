package ThreadModel;

/**
 * @description: 用户线程不存在之后，守护线程亦会结束
 * @author: Damon
 * @date 2021/9/25 10:36
 */
public class DaemonDemo {
    public static class DaemonT extends Thread{
        @Override
        public void run() {
            while (true){
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            Thread t = new DaemonT();
            //在start()方法之前执行
            t.setDaemon(true);
            t.start();
            Thread.sleep(2000);
        }
    }
}
