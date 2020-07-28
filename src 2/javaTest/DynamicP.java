package javaTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//import org.springframework.cglib.proxy.Enhancer;
//import org.springframework.cglib.proxy.MethodInterceptor;
//import org.springframework.cglib.proxy.MethodProxy;
public class DynamicP {
    //jdk动态代理  client必须要实现某个接口
    interface Shopping{
        public void buy(String s);
    }
   static  class Client1 implements Shopping{

        @Override
        public void buy(String s) {
            System.out.println("client1 buy  goods");
        }
    }
   static  class Client2 implements Shopping{

        @Override
        public void buy(String s) {
            System.out.println("client2 buy goods");
        }
    }
    static class DynamicPro implements InvocationHandler{
       private Object obj=null;

        public DynamicPro(Object obj) {
            this.obj = obj;
        }
        public Object transObj(Object obj){
            this.obj=obj;
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
        }
        //代理包装好的对象调用方法时都会经过invoke方法，在这里可以金鑫一些验证过滤操作等
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("代理对象执行方法");
            method.invoke(proxy,args);
            return proxy;
        }
    }
    static void dynamicTestJDK(){
        Shopping c1=new Client1();
        Shopping c2=new Client2();
        DynamicPro dynamicPro=new DynamicPro(c1);
        try {
            Shopping daili = (Shopping) Proxy.newProxyInstance(c1.getClass().getClassLoader(), c1.getClass().getInterfaces(), dynamicPro);
            daili.buy("dsd");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    static class Client{
        public void buy(){
            System.out.println("buy");
        }
    }
//    static class DynamicProCLIB implements MethodInterceptor{
//
//    }
    public static void main(String[] argc){
        dynamicTestJDK();
    }



}
