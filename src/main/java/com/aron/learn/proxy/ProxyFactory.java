package com.aron.learn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Aron on 2017/10/13.
 */
public class ProxyFactory {
    private Object targetObject;
    private BeforeAdvise beforeAdvise;
    private AfterAdvise afterAdvise;

    public Object createProxy(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class[] interfaces = targetObject.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(beforeAdvise != null){
                    beforeAdvise.before();
                }

                Object result = method.invoke(targetObject, args);

                if (afterAdvise != null){
                    afterAdvise.after();
                }
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }

    public Object getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public BeforeAdvise getBeforeAdvise() {
        return beforeAdvise;
    }

    public void setBeforeAdvise(BeforeAdvise beforeAdvise) {
        this.beforeAdvise = beforeAdvise;
    }

    public AfterAdvise getAfterAdvise() {
        return afterAdvise;
    }

    public void setAfterAdvise(AfterAdvise afterAdvise) {
        this.afterAdvise = afterAdvise;
    }



}
