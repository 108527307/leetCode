package algorithm.jianzhiOffer;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Q4 {
    public static void main(String argc[]){
        String s="\\xe2\\x80\\x93".replaceAll("\\\\x","%");
        try {
            System.out.print(URLDecoder.decode(s,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
