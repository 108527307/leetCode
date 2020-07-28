package algorithm.LeetCode;

public class Wildcard_Matching {
    /**
     * @return boolean
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 17/4/2019 3:39 PM
     * @desc: 44 通配符匹配 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
     * <p>
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符串（包括空字符串）。
     * 两个字符串完全匹配才算匹配成功。
     */
    public boolean isMatch(String s, String p) {
        int sl = s.length(), pl = p.length();
        boolean[][] m = new boolean[sl + 1][pl + 1];//存放m[i][j]表示s[i]和p[j]的子串是否都匹配，默认都是false
        m[0][0] = true;//当s和p都为空时
        for (int i = 0; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                if (p.charAt(j - 1) == '*') {//当前扫到p[j-1]为*，则有两种情况，一种*号表示空字符串，一种*复制了前面的字符，第一种情况，要让s和p-1继续匹配，第二种情况要让p和s-1进行匹配
                    m[i][j] = m[i][j - 1] || (i > 0 && m[i - 1][j]);
                } else {
                    //若不是*，则简单了，ij的匹配情况肯定依赖于s i-1 和 p j-1 的匹配情况和 当前扫到的两个字符的匹配情况，而当前扫到的两个字符有两种情况，第一个两个字符相同，第二种情况p中的当前字符是一个占位符？，等效于相等
                    m[i][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                            && m[i - 1][j - 1];
                }
            }
        }
        return m[sl][pl];
    }


    public static void main(String atgc[]) {
        System.out.print(new Wildcard_Matching().isMatch("b", "*b"));
    }
}

