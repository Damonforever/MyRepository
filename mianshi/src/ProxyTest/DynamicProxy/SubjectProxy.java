package ProxyTest.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: Damon
 * @date 2021/9/4 14:36
 */
public class SubjectProxy implements InvocationHandler {
    private Object subject = null;
    public SubjectProxy(Object subject){
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke " + method.getName());
        method.invoke(subject,args);
        System.out.println("After invoke " + method.getName());
        return null;
    }
}
