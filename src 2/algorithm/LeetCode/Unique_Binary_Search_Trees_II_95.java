package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Unique_Binary_Search_Trees_II_95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<TreeNode>();
        else
            return recursion(1, n);
    }
  /**
   * 本题采用递归的方式，
   * */
    public List<TreeNode> recursion(int start, int end) {
        List<TreeNode> all_trees = new ArrayList<>();
        if (start > end) {
            all_trees.add(null);
            return all_trees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left_tree = recursion(start, i - 1);
            List<TreeNode> right_tree = recursion(i + 1, end);
            //l表示左子树的一种可能，r表示右子树的一种可能，这样当前i为根的树的个数就是左列表每种值和右列表的每种值的的笛卡尔积
            for (TreeNode l : left_tree)
                for (TreeNode r : right_tree) {
                    //新建以i为根的一棵树，种类数就是左树和右树的乘积
                    TreeNode currentNode = new TreeNode(i);
                    currentNode.left = l;
                    currentNode.right = r;
                    all_trees.add(currentNode);
                }
        }
        return all_trees;
    }

    public void show(List<TreeNode> list) {
        for (TreeNode i : list) {
            if (i == null)
                return;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(i);
            TreeNode o;
            while (!q.isEmpty()) {
                o = q.poll();
                System.out.print(o.val);
                if (o.left != null)
                    q.offer(o.left);


                if (o.right != null)
                    q.offer(o.right);


            }
            System.out.println();
        }

    }

    public static void main(String[] argc) {
        List<TreeNode> trees = new Unique_Binary_Search_Trees_II_95().generateTrees(3);
        new Unique_Binary_Search_Trees_II_95().show(trees);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
