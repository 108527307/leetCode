package algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            res = Math.max(res, right - left + 1);

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("sfasdfadfsdfasdf"));
    }
}
