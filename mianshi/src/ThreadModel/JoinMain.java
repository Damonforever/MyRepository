package ThreadModel;

/**
 * @description: join 是让main主线程等待 at线程结束，再执行之后的操作
 * @author: Damon
 * @date 2021/9/25 9:59
 */
public class JoinMain {
    public volatile static int i = 0;
    public static class AddThread extends Thread{
        @Override
        public void run() {
            for (i = 0; i < 10000000; i++) {

            }
        }
    }
    public static void main(String[] args) throws InterruptedException{
        AddThread at = new AddThread();
        at.start();
//        at.join();
        System.out.println(i);
    }

}
