package com.aron.learn.proxy;

import org.junit.Test;

/**
 * Created by Aron on 2017/10/13.
 */
public class ProxyFactoryTest {
    @Test
    public void func1() throws Exception {
        ProxyFactory factory = new ProxyFactory();
        factory.setTargetObject(new Waiter());
        factory.setBeforeAdvise(new BeforeAdvise() {
            @Override
            public void before() {
                System.out.println("您好");
            }
        });
        factory.setAfterAdvise(new AfterAdvise() {
            @Override
            public void after() {
                System.out.println("好的");
            }
        });

        Serve serve = (Serve)factory.createProxy();
        serve.serve();
        String res = serve.getServiceName();
        System.out.println(res);
    }

    class Waiter implements Serve {
        @Override
        public void serve() {
            System.out.println("服务中...");
        }
        public String getServiceName(){
            return "上菜";
        }
    }

    interface Serve {
        public void serve();
        public String getServiceName();
    }

}
