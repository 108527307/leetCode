//package java;
//
//import java.util.function.IntConsumer;
//
//class ZeroEvenOdd {
//    private int n;
//    private  int i=1;
//    private volatile boolean evenFlag=false,zeroFlag=true;
//    private Object obj=new Object();
//    public ZeroEvenOdd(int n) {
//        this.n = n;
//    }
//
//    public static void main(String[] args) {
//        ZeroEvenOdd zeroEvenOdd=new ZeroEvenOdd(2);
//        Thread a=new
//    }
//
//    // printNumber.accept(x) outputs "x", where x is an integer.
//    public void zero(IntConsumer printNumber) throws InterruptedException {
//        while(i<=n){
//            synchronized(obj){
//                if(zeroFlag){
//                    printNumber.accept(0);
//                    zeroFlag=false;
//                    obj.notify();
//                    try{
//                        obj.wait();
//                    }catch(Exception e){
//
//                    }
//                }
//            }
//        }
//    }
//
//    public void even(IntConsumer printNumber) throws InterruptedException {
//        while(i<=n){
//            synchronized(obj){
//                if(!zeroFlag&&evenFlag){
//                    printNumber.accept(i++);
//                    evenFlag=false;
//                    zeroFlag=true;
//                    obj.notify();
//                    try{
//                        obj.wait();
//                    }catch(Exception e){
//
//                    }
//                }
//
//            }
//        }
//    }
//
//    public void odd(IntConsumer printNumber) throws InterruptedException {
//        while(i<=n){
//            synchronized(obj){
//                if(!zeroFlag&&!evenFlag){
//                    printNumber.accept(i++);
//                    evenFlag=true;
//                    zeroFlag=true;
//                    obj.notify();
//                    try{
//                        obj.wait();
//                    }catch(Exception e){
//
//                    }
//                }
//
//            }
//        }
//    }
//}