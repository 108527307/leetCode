package algorithm.jianzhiOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Q20 {
    boolean isNumber(char c) {
        return c <= 57 && c >= 48;
    }

    public boolean isNumber(String s) {
        s=s.trim();
        if (s.equals("") || (s.length()==1)&&!isNumber(s.charAt(0))) return false;

        Map<String, Integer> map = new HashMap<>();
        map.put(".", 0);
        map.put("e", 0);
        map.put("+-", 0);
        map.put("-", 0);
        if (s.charAt(0) == 'e' || s.charAt(0) == 'E')
            return false;
        boolean preIsNum = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ' && (i == 0 || i == s.length() - 1)) continue;
            if (!isNumber(c) && c != 'e' && c != 'E' && c != '+' && c != '-' && c != '.') return false;
            if (c <= 57 && c >= 48) {

                preIsNum = true;
            } else {
                if (c == '.') {
                    if (i == 0) continue;

                    if (map.get(c + "") >= 1 || (i < s.length() - 1 && !isNumber(s.charAt(i + 1))))
                        return false;
                    if ((i == s.length() - 1) && !preIsNum) {
                        return false;
                    }
                    map.put(c + "", 1);
                }
                if (c == 'e' || c == 'E') {
                    if (map.get("e") >= 1) return false;
                    map.put("e", 1);
                    if (!preIsNum) return false;
                    if (i >= s.length() - 1) return false;
                    if (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-') {

                        if (i >= s.length() - 2) return false;
                        if (!isNumber(s.charAt(i + 2))) return false;
                    }
                }
                if (c == '+' || c == '-') {
                    if (i >= 1) {
                        if (i <= s.length() - 1 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E'))
                            return false;
                        if (i == s.length() - 1) return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean ss(String s){
        try{
            double a=Float.parseFloat(s);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public static void main(String[] argc) {
        String s = "sda";
        System.out.println(new Q20().ss(""));
    }
}
