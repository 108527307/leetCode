package javaTest;

import java.util.LinkedHashMap;
import java.util.Map;

class lru<K,V> extends LinkedHashMap{
    private static int MAX_SIZE=0;
    lru(int cap){

        super(cap,0.75f,true);
        MAX_SIZE=cap;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>MAX_SIZE;
    }
}
public class Linker {
    private lru l;
    Linker(int cap){
        l=new lru(cap);

    }
    public int get(int key){
        return (int)this.l.get(key);
    }
    public void put(int key,int value){
        l.put(key,value);
    }
    public static void main(String[] argc){
        Linker a=new Linker(1);
        System.out.println(a.get(1));
    }
}
