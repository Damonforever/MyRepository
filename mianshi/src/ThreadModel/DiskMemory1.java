package ThreadModel;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: Damon
 * @date 2021/8/15 16:40
 */
public class DiskMemory1 {
    //记录磁盘总大小
    private int totalSize;

    //获取一个磁盘的大小，采用随机数生成
    public int getSize(){
        //返回值应当大于0
        return (new Random().nextInt(3) + 1) * 100;
    }

    //统计磁盘空间大小
    public synchronized void setSize(int size){
        totalSize += size;
    }

    //获得总磁盘空间大小
    public int getTotalSize(){
        return totalSize;
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        CountDownLatch count = new CountDownLatch(4);
        DiskMemory1 diskMemory = new DiskMemory1();
        for (int i = 0; i < 4; i++) {
            service.execute(Method(diskMemory,count));
        }
        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("全部磁盘都统计完成,所有磁盘总大小为 " + ", 【 totalSize = " + diskMemory.getTotalSize() + " 】");
        service.shutdown();
    }
    private static Runnable Method(DiskMemory1 diskMemory,CountDownLatch count){
        return new Runnable() {
            @Override
            public void run() {
                int timer = new Random().nextInt(5);
                try {
                    Thread.sleep(timer * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int diskSize = diskMemory.getSize();
                System.out.printf("完成磁盘的统计任务,耗费%d秒. 磁盘大小为%d.\n", timer, diskSize);
                diskMemory.setSize(diskSize);

                //任务完成，计数器减一
                count.countDown();
                System.out.println("count num = " + count.getCount());
            }
        };
    }
}
