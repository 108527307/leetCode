package algorithm;

import java.util.*;


public class Main21 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 使用题目中描述的方法，将 raw_str 压缩后返回
     *
     * @param raw_str string字符串 未压缩的原始字符串
     * @return string字符串
     */
    public static String compress(String raw_str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < raw_str.length(); ) {
            int j = i + 1;
            while (j < raw_str.length() && raw_str.charAt(j) == raw_str.charAt(j - 1)) j++;
            if (j - i >= 4 && j - i <= 55) {
                if (j - i <= 29) {
                    char temp = (char) (97 + (j - i - 4));
                    String s = "0" + temp + raw_str.charAt(i) + "";
                    sb.append(s);
                } else {
                    sb.append("0" + (char) (65 + (j - i - 30)) + raw_str.charAt(i));
                }

            } else if (j - i > 55) {
                int t = (j - i) % 55, g = (j - i) / 55;
                for (int k = 0; k < g; k++) {
                    sb.append("0" + "Z" + raw_str.charAt(i));
                }
                if (t >= 4 && t <= 29)
                    sb.append("0" + (char) (97 + (t - 4)) + raw_str.charAt(i));
                else if (t > 29) sb.append("0" + (char) (65 + (t - 30)) + raw_str.charAt(i));
                else sb.append(raw_str.substring(j - t, j));
            } else {

                sb.append(raw_str.substring(i, j));
            }
            i = j;
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB";
        System.out.println(s.length());
        System.out.println(compress("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"));
    }
}