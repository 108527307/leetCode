package algorithm.jianzhiOffer;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Q7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft >= preorder.length || inLeft > inRight)
            return null;
        TreeNode p = new TreeNode(preorder[preLeft]);
        int inPos = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == preorder[preLeft]) {
                inPos = i;
                break;
            }
        }
        int leftSize = inPos - inLeft;
        p.left = build(preorder, preLeft + 1, preLeft + leftSize, inorder, inLeft, inPos - 1);
        p.right = build(preorder, preLeft + leftSize + 1, preRight, inorder, inPos + 1, inRight);
        return p;

    }
}
