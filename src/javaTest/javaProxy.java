package javaTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

interface Shopping {
    void buy();
}

class Client implements Shopping {
    @Override
    public void buy() {
        System.out.println("我买了");
    }
}

class DynamicProxy implements InvocationHandler {
    private Object target = null;

    DynamicProxy() {
    }

    ;

    DynamicProxy(Object obj) {
        this.target = obj;
    }

    public Object bind(Object obj) {
        this.target = obj;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(" 代理前");
        method.invoke(proxy, args);
        //System.out.println("代理后");
        return proxy;
    }
}

public class javaProxy {
    public static void main(String[] argc){
        Integer[][] aa=new Integer[3][];
        Integer d=1;

        List<Integer[]> a=new ArrayList<>();

        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Shopping s=new Client();//被代理类
        DynamicProxy dynamicProxy=new DynamicProxy();//动态代理类
        Shopping shop=(Shopping) dynamicProxy.bind(s);//通过动态代理类将原来的类进行代理，生成代理对象
        shop.buy();
        String ss=new String();
        //ss.sub

    }
}
