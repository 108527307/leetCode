package algorithm.LeetCode;

import java.util.*;

public class ads {

    public static List<String> words = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mg = sc.nextLine();
        String sent = sc.nextLine();
        String replace = sc.nextLine();
        quan(mg.toCharArray(), 0, mg.length() - 1);
        for (String s : words) {
            sent = sent.replaceAll(s, replace);
        }
        System.out.println(sent);

    }

    public static void quan(char[] chs, int low, int high) {
        if (low == high) {
            words.add(new String(chs));
            return;
        }
        for (int i = low; i <= high; ++i) {
            chs[low] = (char) (chs[i] + chs[low] - (chs[i] = chs[low]));
            quan(chs, low + 1, high);
            chs[low] = (char) (chs[i] + chs[low] - (chs[i] = chs[low]));
        }
    }




}