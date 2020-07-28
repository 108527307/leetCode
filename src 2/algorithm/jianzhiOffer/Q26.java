package algorithm.jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        if (A.val == B.val) return sub(A, B);
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(A);
//        boolean re = false;
//        while (!q.isEmpty()) {
//            TreeNode a = q.poll();
//            if (a.val == B.val){
//                re = sub(a, B);
//                return re;
//            }
//            if (a.left != null) q.add(a.left);
//            if (a.right != null) q.add(a.right);
//        }
// return re;

    }





    boolean sub(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null || a.val != b.val || !sub(a.left, b.left)) return false;
        return sub(a.right, b.right);
    }
}
