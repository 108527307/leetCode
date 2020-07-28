package algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Q50 {
    public char firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char t=s.charAt(i);
               if(map.containsKey(t)){
                   map.put(t,map.get(t)+1);
               }else map.put(t,1);
        }
        for(int i=0;i<s.length();i++){
            char t=s.charAt(i);
            if(map.get(t)==1) return t;
        }
        return ' ';
    }
    public static void main(String argc[]){
        System.out.println(new Q50().firstUniqChar("asdfasdfr"));
//        Map<Integer,Integer> map=new HashMap<>();
//        map.put(1,1);
//        map.put(1,2);
//        System.out.println(map.get(1));
    }
}
