package LockModel;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description: 读写锁
 * @author: Damon
 * @date 2021/8/13 10:18
 */
public class ReadWriteLockTest {
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
}
