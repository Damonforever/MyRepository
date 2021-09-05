package ProxyTest.DynamicProxy;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/4 14:35
 */
public class AnotherSubject implements Subject{
    @Override
    public void doSomething() {
        System.out.println("睡觉");
    }
}
