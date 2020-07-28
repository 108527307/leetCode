package algorithm.jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

public class Q48 {
    List<String[]> list;
    public Q48() {
        list=new ArrayList<>();
    }

    public void checkIn(int id, String stationName, int t) {
        String[] s=new String[4];
        s[0]=id+"";
        s[1]=stationName;
        s[2]=t+"";
        s[3]=0+"";
        this.list.add(s);
    }

    public void checkOut(int id, String stationName, int t) {
        //if(list.size()==null) return;
        String[] s=new String[4];
        s[0]=id+"";
        s[1]=stationName;
        s[2]=t+"";
        s[3]=1+"";
        System.out.println(s.toString());
        this.list.add(s);

    }

    public double getAverageTime(String startStation, String endStation) {
        //List<String[]> list1=new ArrayList<>(),list2=ne;
        double count=0,sum=0;
        for(int i=0;i<list.size();i++){
            String[] s=list.get(i);
            if(s[3].equals("0")&&s[1].equals(startStation))
            {
                for(int j=i+1;j<list.size();j++){
                    String[] t=list.get(j);
                    if(t[3].equals("1")&&t[1].equals(endStation)){
                        count++;
                        sum+=(Double.parseDouble(t[2])-Double.parseDouble(s[2]));
                    }
                }
            }

        }
        if(count==0) return 0;
        return sum/count;
    }
    public static void main(String[] argc){
        Q48 q=new Q48();
        q.checkIn(0,"s",2);
        q.checkOut(0,"ss",4);
        System.out.println(q.getAverageTime("s","ss"));
    }
}
