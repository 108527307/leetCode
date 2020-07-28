package javaTest;

import java.util.*;
/**
 *
  * @return
 * @author chy
 * @creed: Talk is cheap,show me the code
 * @date 23/4/2020 10:38 PM
 * @desc:
 */
public class Ali {
    public static boolean judge(String pattern, String str) {
        //首先我把pattern和str都通过split放个两个list中
        String[] strs = str.split(" ");
        List<String> str_list = new ArrayList(Arrays.asList(strs));

        String[] chars = pattern.split("");
        List<String> pattern_list = new ArrayList(Arrays.asList(chars));

        if (str_list.size() != pattern_list.size()) {
            return false;
        }
        //然后我建立一个HashMap,以pattern中的一个字符为key，对应位置的城市名为value进行存储。
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < pattern_list.size(); i++) {
            String ch = pattern_list.get(i);
            String val = str_list.get(i);
            if (map.containsKey(ch)) {
                if (!ch.equals(val))
                    return false;
            } else {
                if (map.containsValue(val))
                    return false;
                map.put(ch, val);
            }
        }
        return true;
    }



    public static boolean judge1(String pattern, String str) {
        String[] strs = str.split(" ");
        List<String> str_list = new ArrayList(Arrays.asList(strs));


        List<Character> chs_list = new ArrayList();
        char[] chs = pattern.toCharArray();

        for (char c : chs) {
            chs_list.add(c);
        }

        if (str_list.size() != chs_list.size()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < chs_list.size(); i++) {
            if (map.containsKey(chs_list.get(i))) {
                if (map.get(chs[i]).equals(str_list.get(i))) {
                } else {
                    return false;
                }
            } else {
                if(map.containsValue(str_list.get(i))){
                    return false;
                }
                map.put(chs_list.get(i), str_list.get(i));
            }
        }
        return true;

    }


    public static void main(String[] args) {

        String pattern = "babb", str="北京 杭州 杭州 北京";
        System.out.println(judge1(pattern, str));
    }


}
