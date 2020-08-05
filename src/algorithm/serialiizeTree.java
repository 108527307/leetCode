package algorithm;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    public void print() {

        System.out.print(val);
    }
}

public class serialiizeTree {
    public static void serializeTree(TreeNode root, List<TreeNode> t) {
        if (root == null) {
            t.add(new TreeNode(-1));
            return;
        }
        t.add(root);
        serializeTree(root.left, t);
        serializeTree(root.right, t);
    }

    public TreeNode de(List<TreeNode> t, int index) {
        int temp = index;
        if (temp >= t.size() || t.get(temp).val == -1) return null;
        t.get(temp).left = de(t, index++);
        t.get(temp).right = de(t, index++);
        return t.get(temp);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        n1.left = n2;
        n2.left = n4;
        n4.left = n8;
        n2.right = n5;
        n1.right = n3;
        n3.left = n6;
        n6.left = n9;
        n3.right = n7;
        List<TreeNode> list = new ArrayList<>();
        serializeTree(n1, list);
        list.forEach(TreeNode::print);
    }
}
