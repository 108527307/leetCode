package algorithm;// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.*;

public class Main20 {
    public static PriorityQueue<String> p = new PriorityQueue<String>(Comparator.reverseOrder());
    public static String AA = "";
    public static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int N = Integer.parseInt(sc.nextLine());
        String A = sc.nextLine();
        AA = A;
//        String B = sc.nextLine();
        char[] nums;
        String temp = A;
        int i = 0;
        nums = temp.toCharArray();
        //Arrays.sort(n ums);
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {

                break;
            }
        }
        if (i == -1 || (i == 0 && nums[i+1] == '0')) {
            System.out.println(0);
            return;
        }

        Character[] tt = new Character[nums.length - i - 1];
        for (int j = i + 1; j < nums.length; j++)
            tt[j - i - 1] = nums[j];
        Arrays.sort(tt, Collections.reverseOrder());
        for (int j = i + 1; j < nums.length; j++)
            nums[j] = tt[j - i - 1];
        swap(nums, i, i + 1);
        String t = "";
        for (char k : nums)
            t += k + "";
        // p.add(t);
        if (t.charAt(0) == '0') {

        }

        if (t.compareTo(AA) < 0) {

            System.out.println(t);
        }


    }

    public static void per(char[] nums, int begin) {
        if (flag) return;
        if (begin == 0) {
//            String t = "";
//            for (char i : nums)
//                t += i + "";
//            // p.add(t);
//            if (t.compareTo(AA) < 0) {
//                flag = true;
//                System.out.println(t);
//                return;
//            }
        } else {
            for (int i = nums.length - 1; i >= 0; i--) {
                swap(nums, begin, i);
                String t = "";
                for (char k : nums)
                    t += k + "";
                // p.add(t);
                if (t.charAt(0) == '0') continue;
                if (t.compareTo(AA) < 0) {
                    flag = true;
                    p.add(t);
                    System.out.println(t);
                    return;
                }
                per(nums, begin - 1);
                swap(nums, begin, i);
            }
        }
    }

    public static void swap(char[] nums, int i, int j) {
        char t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}