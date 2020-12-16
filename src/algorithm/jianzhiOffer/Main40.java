package algorithm.jianzhiOffer;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class N {
    String val;
    N left, right, p;

    N(String x) {
        val = x;
    }
}

public class Main40 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] po = in.nextLine().split(",");
        if (po.length == 0) {
            System.out.println("");
            return;
        }
        Queue<N> q = new LinkedList();

        for (int i = 0; i < po.length; ) {
            N root = new N(po[i++]);
            q.add(root);

        }
        N root1 = q.peek();
        while (!q.isEmpty()) {
            N root = q.poll();
            root.left = q.poll();
            root.right = q.poll();
            if (root.left != null)
                root.left.p = root;
            if (root.right != null)
                root.right.p = root;
        }
        N newRoot = root1;
        while (newRoot.left != null) newRoot = newRoot.left;
        jj(newRoot);
        q.add(newRoot);
        while (!q.isEmpty()) {
            N temp = q.poll();
            System.out.println(temp.val);
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }
    }

    public static void jj(N root) {
        if (root == null) return;
        N temp = root.p, tempLeft = root.left, tempRight = root.right;
        if (root.p != null)
            root.left = root.p.right;
        root.right = root.p;
        jj(temp);
        //jj(tempRight);

    }
}