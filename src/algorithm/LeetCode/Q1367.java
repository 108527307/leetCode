package algorithm.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 首先用层次遍历找到第一个匹配点，然后用dfs进行逐个匹配即可
 */
public class Q1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode currentNode = null;
        while (!q.isEmpty()) {
            currentNode = q.poll();
            if (currentNode.val == head.val && dfs(head, root))
                return true;
            if (currentNode.left != null)
                q.add(currentNode.left);
            if (currentNode.right != null)
                q.add(currentNode.right);
        }
        return false;
    }

    boolean dfs(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val != root.val) return false;
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }
}
