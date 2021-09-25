package ThreadModel;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/24 9:33
 */
public class CreateThread implements Runnable{
    public static void main(String[] args) {
        Thread t1 = new Thread(new CreateThread());
        t1.start();
    }
    @Override
    public void run() {
        System.out.println("hello");
    }
}
