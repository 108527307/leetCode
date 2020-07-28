package algorithm.LeetCode;

public class Regular_Expression_Matching {
    /**
     * @return boolean
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 19/4/2019 7:44 PM
     * @desc: 10. 正则表达式匹配
     * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
     * <p>
     * '.' 匹配任意单个字符。
     * '*' 匹配零个或多个前面的元素。
     * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
     */
    public boolean isMatch(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();
//        if (p.length() == 1 && p.charAt(0) == '*')
//            return true;
        boolean first_match = (!s.isEmpty()) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        if (p.length() == 1 && p.charAt(0) == '*') {
            boolean isSame = true;
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) != s.charAt(i + 1))
                    isSame = false;
            }
            if (isSame)
                return true;
        }
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p));
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String argc[]) {
        System.out.print(new Regular_Expression_Matching().isMatch("aaaaaaaab", "*"));
    }
}
