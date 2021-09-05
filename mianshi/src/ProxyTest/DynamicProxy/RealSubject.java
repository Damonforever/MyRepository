package ProxyTest.DynamicProxy;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/4 14:34
 */
public class RealSubject implements Subject{
    @Override
    public void doSomething() {
        System.out.println("吃饭");
    }
}
