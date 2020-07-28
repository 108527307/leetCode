package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Group_Anagrams_49 {
    /**
     * @return java.util.List<java.util.List<java.lang.String>>
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 9/5/2019 12:43 PM
     * @desc:49 字母异味词分组  给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 解法一 使用质数相乘
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> temp = new HashMap<String, Integer>();
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        for (int i = 97; i <= 122; i++) {
            temp.put((char) i + "", primes[i - 97]);
        }
        HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            int wordSum = 1;
            for (int j = 0; j < strs[i].length(); j++) {
                wordSum *= temp.get(strs[i].charAt(j) + "");
            }
            if (res.containsKey(wordSum)) {
                List<String> temp2 = result.get(res.get(wordSum));
                temp2.add(strs[i]);
                result.set(res.get(wordSum), temp2);

            } else {
                List<String> temp3 = new ArrayList<>();
                temp3.add(strs[i]);
                result.add(temp3);
                res.put(wordSum, result.indexOf(temp3));
            }
        }
        return result;
    }

    public static void main(String[] argc) {
        for (List<String> ii : new Group_Anagrams_49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat" })) {
            for (String item : ii)
                System.out.print(item+" ");
            System.out.println();
        }
    }
}
