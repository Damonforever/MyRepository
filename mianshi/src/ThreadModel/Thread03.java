package ThreadModel;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/24 10:11
 */
public class Thread03 {
    final static Object object = new Object();
    public static class T1 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis() + ": T1 start!");
                try {
                    System.out.println(System.currentTimeMillis() + ": T1 wait for object");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ": T1 end!");
            }
        }
    }
    public static class T2 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis() + ": T2 start! notify one Thread");
                object.notify();
                System.out.println(System.currentTimeMillis() + ": T2 end!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
//
//        Thread t1 = new Thread(() -> {
//            synchronized (object){
//                System.out.println(System.currentTimeMillis() + ": T1 start!");
//                try {
//                    System.out.println(System.currentTimeMillis() + ": T1 wait for object");
//                    object.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(System.currentTimeMillis() + ": T1 end!");
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            synchronized (object){
//                System.out.println(System.currentTimeMillis() + ": T2 start! notify one Thread");
//                object.notify();
//                System.out.println(System.currentTimeMillis() + ": T2 end!");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });
        t1.start();
        t2.start();
    }
}
