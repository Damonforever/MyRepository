package ThreadModel;

/**
 * @description: 线程组
 * @author: Damon
 * @date 2021/9/25 10:28
 */
public class ThreadGroupName implements Runnable {
    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("PrintGroup");
        Thread t1 = new Thread(tg,new ThreadGroupName(),"T1");
        Thread t2 = new Thread(tg,new ThreadGroupName(),"T2");
        t1.start();
        t2.start();
        System.out.println(tg.activeCount());
        tg.list();
    }

    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName();
        while (true){
            System.out.println("I am " + groupAndName);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
