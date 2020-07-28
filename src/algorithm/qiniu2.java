package algorithm;

import java.net.MalformedURLException;
import java.util.Scanner;
import java.net.URL;

public class qiniu2 {
    public static void main(String[] argc) {
        Scanner in = new Scanner(System.in);
        String str = "https://10.10.10.10:8080/my/test/path2";
        if (str.charAt(0) != 'h')
            str = "http://" + str;
        try {
            URL url = new URL(str);
            int port = url.getPort();
            if (port == -1) port = url.getDefaultPort();
            String query = url.getQuery();
            if (query == null) query = "";
            String path=url.getPath();
            String re = url.getHost() + " "+ port + " "+ path + query;
            System.out.print(re);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
//        int T = Integer.parseInt(in.nextLine());
//        for (int i = 0; i < T; i++) {
//            String str = in.nextLine();
//            if (str.length() == 1) {
//                System.out.println("Yes");
//                continue;
//            }
//            Stack<Character> s = new Stack<>();
//            int j = 1;
//            s.add(str.charAt(0));
//            while (j < str.length() && !s.isEmpty()) {
//                if (str.charAt(j) == s.peek()) {
//                    s.pop();
//
//                } else {
//                    s.add(str.charAt(j));
//                }
//                j++;
//                if (s.isEmpty() && j < str.length()) {
//                    s.add(str.charAt(j++));
//                }
//
//            }
//            if (s.isEmpty()) System.out.println("Yes");
//            else System.out.println("No");
//
//        }
    }
}
