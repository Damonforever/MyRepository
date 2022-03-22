package RandomAccessFileTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * @description:
 * @author: Damon
 * @date 2022/3/21 22:03
 */
public class RAFTestFactory {
    private static final String url = "F:\\test.txt";
    //四种读写模式
    private static final String[] model = {"r","rw","rws","rwd"};

    public static RandomAccessFile getRAFWithModelR() throws FileNotFoundException{

        RandomAccessFile raf = new RandomAccessFile(url, model[0]);
        return raf;
    }
    public static RandomAccessFile getRAFWithModelRW() throws FileNotFoundException{

        RandomAccessFile raf = new RandomAccessFile(url, model[1]);
        return raf;
    }
    public static RandomAccessFile getRAFWithModelRWS() throws FileNotFoundException{

        RandomAccessFile raf = new RandomAccessFile(url, model[2]);
        return raf;
    }
    public static RandomAccessFile getRAFWithModelRWD() throws FileNotFoundException{

        RandomAccessFile raf = new RandomAccessFile(url, model[3]);
        return raf;
    }
}
