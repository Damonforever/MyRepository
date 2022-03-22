package RandomAccessFileTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @description:
 * @author: Damon
 * @date 2022/3/21 22:35
 */
public class RAFTestMain {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = RAFTestFactory.getRAFWithModelR();
        System.out.println("获取文本长度：" + raf.length());
        System.out.println("获取文本头指针：" + raf.getFilePointer());
        raf.seek(4);
        System.out.println("二次获取头指针：" + raf.getFilePointer());
    }
}
