package com.aron.learn.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Aron on 2017/10/13.
 */
public class ProxyDemo {
    @Test
    public void func1(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("hello");
                return null;
            }
        };
        Object object = Proxy.newProxyInstance(classLoader, new Class[]{A.class, B.class}, invocationHandler);
        A a = (A)object;
        B b = (B)object;
        a.a();
        b.b();
    }
}

interface A {
    public void a();
}

interface B {
    public void b();
}

class myInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
