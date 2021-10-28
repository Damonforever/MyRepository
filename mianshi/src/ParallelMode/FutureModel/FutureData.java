package ParallelMode.FutureModel;

import javax.xml.crypto.Data;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/27 15:35
 */
public class FutureData implements Data {
    protected RealData realData = null; // FutureData是RealData的包装
    protected boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        if (isReady){
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();//RealData已经被注入，通知getResult()方法
    }
    public synchronized String getResult(){//等待RealData构造完成
        while (!isReady){
            try {
                wait();// 一直等待，直到RealData被注入
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.result;
    }
}
