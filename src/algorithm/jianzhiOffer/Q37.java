package algorithm.jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

public class Q37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuffer sf = new StringBuffer("[");
        while (!q.isEmpty()) {
            TreeNode cur = q.remove();
            if (cur != null) {
                sf.append(cur.val + ",");
                q.add(cur.left);
                q.add(cur.right);
            } else sf.append("null,");

        }

        sf.replace(sf.length() - 1, sf.length(), "]");
        return sf.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int len = data.length();
        if (len == 2 || len == 0) return null;
        data = data.substring(1, len - 1);
        String[] vals = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(vals[index++]));
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(cur==null) continue;
            System.out.println(cur.val + "," + index);
            if (index >= vals.length) break;
            cur.left = generalizeNode(vals[index++]);
            if (index >= vals.length) break;
            cur.right = generalizeNode(vals[index++]);
            //if (cur.left != null)
                q.add(cur.left);
            //if (cur.right != null)
                q.add(cur.right);
        }

        return root;

    }

    TreeNode generalizeNode(String value) {
        if (value.equals("null")) return null;
        return new TreeNode(Integer.parseInt(value));
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root.left = root2;
        root.right = root3;
        root3.left = root4;
        root3.right = root5;
        Q37 q = new Q37();
        //System.out.println(new Q37().serialize(root));
        String de = "[5,2,3,null,null,2,4,3,1]";
        System.out.println(q.serialize(q.deserialize(de)));
        StringBuffer a=new StringBuffer();

    }
}
