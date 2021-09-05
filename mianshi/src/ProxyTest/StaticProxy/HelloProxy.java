package ProxyTest.StaticProxy;

/**
 * @description:静态代理
 * @author: Damon
 * @date 2021/9/4 14:27
 */
public class HelloProxy implements Hello{

    private Hello hello = new HelloClass();
    @Override
    public void sayHello() {
        System.out.println("先做点儿啥");
        hello.sayHello();
        System.out.println("之后做点儿啥");
    }
}
