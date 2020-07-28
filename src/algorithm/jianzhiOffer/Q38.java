package algorithm.jianzhiOffer;

import java.util.*;

public class Q38 {
    List<String> res;
    Set<String> a;
    int len;

    public String[] permutation(String s) {
        len = s.length();
        a = new HashSet<>();
        res = new ArrayList<>();
        String[] ss = s.split("");
        sub(ss, 0);

        return res.toArray(ss);
    }

    void sub(String[] s, int k) {
        if (k == len-1) {
            StringBuffer re = new StringBuffer();
            for (String ch : s)
                re.append(ch);
            if (!a.contains(re.toString())) {
                res.add(re.toString());
                a.add(re.toString());
            }
        } else {
            for (int i = k; i < len; i++) {
                swap(s, k, i);
                sub(s, k+1);
                swap(s, k, i);
            }
        }
    }

    void swap(String[] s, int i, int j) {
        String temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] argc) {
        String[] qq=new Q38().permutation("adbc");
        int[] as=new int[10];
        return;
    }

}
