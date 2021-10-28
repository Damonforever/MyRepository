package ParallelMode.FutureModel;

import java.util.Date;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/27 15:48
 */
public class Client {
    public FutureData request(final String queryStr){
        final FutureData future = new FutureData();
        new Thread(() -> {
            RealData realData = new RealData(queryStr);
            future.setRealData(realData);
        }).start();
        return future;
    }

    public static void main(String[] args) {
        Client client = new Client();
        FutureData date = client.request("name");
        System.out.println("请求完毕");
        try {
            //代替其他的业务逻辑
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据 = " + date.getResult());
    }
}
