package algorithm.jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

public class Q28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            String[] vals = new String[size * 2];
            int count = 0;
            while (count < size * 2) {
                TreeNode a = q.poll();

                //if ((a.left == null) ^ (a.right == null)) return false;
                vals[count] = "null";
                vals[count + 1] = "null";
                if (a.left != null) {
                    vals[count] = a.left.val + "";
                    q.add(a.left);
                }
                if (a.right != null) {
                    q.add(a.right);
                    vals[count + 1] = a.right.val + "";
                }
                count += 2;


            }
            for (int i = 0; i < size * 2; i++) {
                if (vals[i].equals(vals[size * 2 - i - 1])) return false;
            }
        }
        return true;
    }
    public boolean isSymmetric1(TreeNode root) {
        if (root==null) return true;
        return subIsSymmetric1(root.left,root.right);
    }

    boolean subIsSymmetric1(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null || l.val != r.val) return false;
        return subIsSymmetric1(l.left,r.right)&&subIsSymmetric1(l.right,r.left);
    }
}
