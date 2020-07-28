package algorithm.jianzhiOffer;

import java.util.*;

public class Q32_l {
    String fuck="";
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        //Queue<TreeNode> q=new LinkedList<>();
        //q.add(root);
        TreeNode[] q = new TreeNode[1001];
        int start = 0, end = 0;
        q[++end] = root;
        List<Integer> reList = new ArrayList<>();

        while (start != end) {
            TreeNode cursor = q[++start];
            reList.add(cursor.val);
            if (cursor.left != null) q[++end] = cursor.left;
            if (cursor.right != null) q[++end] = cursor.right;
        }
        Integer[] re = new Integer[reList.size()];
        reList.toArray(re);

        //List<List<Integer>> ss=new ArrayList<ArrayList<Integer>>();
        return Arrays.stream(re).mapToInt(Integer::valueOf).toArray();
    }
}
