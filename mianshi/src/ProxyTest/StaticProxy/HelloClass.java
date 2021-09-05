package ProxyTest.StaticProxy;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/4 14:26
 */
public class HelloClass implements Hello{
    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
