package algorithm;

import java.util.*;

public class Main11 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        int n = Integer.parseInt(sc.nextLine());
        String[] vals1 = sc.nextLine().split(" ");
        int m = Integer.parseInt(sc.nextLine());
        String[] vals2 = sc.nextLine().split(" ");
        int maxVal = -1, minVal = 1000001;
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(vals1[i]);
            s1.add(temp);
            maxVal = Math.max(maxVal, temp);
            minVal = Math.min(minVal, temp);
        }
        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(vals2[i]);
            s2.add(temp);
            maxVal = Math.max(maxVal, temp);
            minVal = Math.min(minVal, temp);
        }
        for (int i = maxVal; i >= minVal; --i) {
            if (s1.contains(i) && s2.contains(i)) {
                System.out.print(i + " ");
            }
        }

    }
}