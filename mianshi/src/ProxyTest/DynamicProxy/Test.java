package ProxyTest.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/4 14:41
 */
public class Test {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        AnotherSubject anotherSubject = new AnotherSubject();
        InvocationHandler handler = new SubjectProxy(realSubject);
        InvocationHandler handler1 = new SubjectProxy(anotherSubject);
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);
        Subject subject1 = (Subject) Proxy.newProxyInstance(handler1.getClass().getClassLoader(), anotherSubject.getClass().getInterfaces(),handler1);
        subject.doSomething();
        subject1.doSomething();
    }
}
