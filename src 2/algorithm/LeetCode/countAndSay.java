package algorithm.LeetCode;

public class countAndSay {
    /*
     *
      * @return java.lang.String
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 9/4/2019 1:49 PM
     * @desc: 38 报数
     */
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        if (n == 2)
            return "11";
        else {
            String strr = countAndSay(n - 1);
            StringBuffer re = new StringBuffer();
            int count = 0;

            for (int i = strr.length() - 1; i >= 0; i--) {
                if (i == 0) {
                    if (strr.charAt(i) != strr.charAt(i + 1))

                        count = 0;

                }
                if (i >= 1 && strr.charAt(i) == strr.charAt(i - 1)) {
                    count++;
                } else {

                    re.append(strr.charAt(i));
                    re.append(String.valueOf(count + 1));
                    count = 0;

                }
            }
            return re.reverse().toString();
        }
    }

    public static void main(String argc[]) {
        System.out.print(new countAndSay().countAndSay(5));
    }

}
