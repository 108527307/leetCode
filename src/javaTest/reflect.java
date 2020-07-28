package javaTest;

import java.lang.reflect.Array;

public class reflect {
    public static Object goodCopyOf(Object obj,int newLength){
        Class c=obj.getClass();
        if(!c.isArray()) return null;
        Class componentType=c.getComponentType();
        int length= Array.getLength(obj);
        Object newArrat=Array.newInstance(componentType,newLength);
        System.arraycopy(obj,0,newArrat,0,Math.min(length,newLength));
        return newArrat;
    }
    public static void main(String[] argc){
        reflect re=new reflect();
        int[] s=(int[])re.goodCopyOf(new int[]{1,2,3},2);
        StringBuffer ss=new StringBuffer();

        System.out.println();
    }
}
