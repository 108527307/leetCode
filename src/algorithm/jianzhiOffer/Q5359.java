package algorithm.jianzhiOffer;



import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Q5359 {
    int[][] res;
    private int num;

    public Q5359(int num) {
        this.num = num;
    }

    int tuandui=0;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        int maxTeam=0;
        for(int e=4;e<=4;e++){

            int sp[]=new int[speed.length],ef[]=new int[efficiency.length];
            for(int i=0;i<sp.length;i++)
                sp[i]=speed[i];
            for(int i=0;i<efficiency.length;i++)
                ef[i]=efficiency[i];
            //int e=6;
            res=new int[e][2];
            for(int i=0;i<e;i++){
                res[i][0]=sp[i];
                res[i][1]=ef[i];
            }
            int maxSub=teamScore(e);
            maxTeam=maxSub>maxTeam?maxSub:maxTeam;
            //maxTeam=teamScore(e);
            for(int i=e;i<n;i++){
                int jiadezuiduo=0;
                int index=0;
                for(int j=0;j<e;j++){
                    swap(sp,ef,j,i,true);
                    int max=teamScore(e);
                    if(max>jiadezuiduo){
                        jiadezuiduo=max;
                        index=j;
                    }
                    swap(sp,ef,j,i,false);
                }
                maxSub=maxSub>jiadezuiduo?maxSub:jiadezuiduo;
                maxTeam=maxTeam>jiadezuiduo?maxTeam:jiadezuiduo;
                if(jiadezuiduo>=maxSub)
                    swap(sp,ef,index,i,false);
            }
        }
        return maxTeam;

    }
    void swap(int speed[],int[] eff,int i,int j,boolean is){
        //     if(is){
        //     res[i][0]=speed[j];
        //     res[i][1]=eff[j];
        //     }
        //     else
        //     {
        //         speed[j]=res[i][0];
        //     eff[j]=res[i][1];
        // }
        res[i][0]=res[i][0]+speed[j]-(speed[j]=res[i][0]);
        res[i][1]=res[i][1]+eff[j]-(eff[j]=res[i][1]);
    }
    int teamScore(int k){
        int sumSpeed=0,minEc=res[0][1];
        for(int i=0;i<k;i++){
            sumSpeed+=res[i][0];
            minEc=minEc>res[i][1]?res[i][1]:minEc;
        }
        return sumSpeed*minEc;
    }
    public static void main(String[] argc){
//        int n=8,k=4;
//        int[] speed=new int[]{9,9,4,6,9,7,9,8};
//          int[] eff=new int[]{1,9,1,9,8,1,10,1};
//        int max=new Q5359().maxPerformance(n,speed,eff,k);
//        System.out.println(max);
        Q5359 q=new Q5359(2);

//        System.out.println(q.hashCode());
        try {
//              Field[] f=Double.class.getDeclaredFields();
//            Method[] ms=Double.class.getMethods();
//            Constructor[] c=Double.class.getConstructors();
//            for(Constructor m:c)
//                System.out.println(m);
//            System.out.println("");
//            for(Field m:f)
//                System.out.println(m);
//            System.out.println("");
//              for(Method m:ms)
//            System.out.println(m.getReturnType());
            Field f=Q5359.class.getDeclaredField("num");
            //f.set(q,3);
            //f.setAccessible(true);
            System.out.println(f.getInt(q));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
