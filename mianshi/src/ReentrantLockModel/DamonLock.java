package ReentrantLockModel;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/19 21:08
 */
public class DamonLock {
    private static final Unsafe unsafe = getUnsafe();

    private  volatile  int state;
    private static long stateOffset;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(DamonLock.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    public void lock(){
        while (!unsafe.compareAndSwapInt(this, stateOffset, 0, 1)){
            System.out.println(Thread.currentThread().getName() + "正在加锁");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "加到锁了");
    }

    public void unlock(){
        state = 0;
    }

    private static Unsafe getUnsafe(){
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            return null;
        }
    }
}
