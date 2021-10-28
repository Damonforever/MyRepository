package ParallelMode.FutureModel;

import javax.xml.crypto.Data;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/27 15:36
 */
public class RealData implements Data {
    protected final String result;

    public RealData(String para) {
        //RealData的构造可能很慢，需要用户等待很久，这里用sleep模拟
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        result = sb.toString();
    }

    public String getResult() {
        return result;
    }
}
