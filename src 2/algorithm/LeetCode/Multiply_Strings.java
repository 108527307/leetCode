package algorithm.LeetCode;

public class Multiply_Strings {
    /**
     * @return java.lang.String
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 16/4/2019 6:37 PM
     * @desc: 43.字符串相乘 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int[] temp = new int[num1.length() + num2.length()];
        int t = 0, i = 0, j = 0;
        for (i = num1.length() - 1; i >= 0; i--) {
            t = 0;
            for (j = num2.length() - 1; j >= 0; j--) {
                int a = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + temp[i + j + 1] + t;
                if (a < 10) {
                    temp[i + j + 1] = a;
                    t = 0;
                } else {
                    temp[i + j + 1] = a % 10;
                    t = a / 10;
                }
            }
            if (t != 0)
                temp[i + j + 1] = t;
        }
        StringBuffer re = new StringBuffer();
        int index = 0;
        while (temp[index++] == 0) ;
        for (int h = index - 1; h < temp.length; h++) {
//            re += (temp[h] + "");
            re.append(temp[h]);
        }

        return re.toString();
    }

    public static void main(String[] argc) {
        System.out.print(new Multiply_Strings().multiply("0", "3"));
    }
}
