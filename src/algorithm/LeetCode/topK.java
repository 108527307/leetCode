package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class topK {
    public static List getTopK(int[] nums, int k) {
        if (k >= nums.length) return null;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i : nums) {
            maxHeap.add(i);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList(maxHeap);

    }
}
