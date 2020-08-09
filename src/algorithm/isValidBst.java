package algorithm;

public class isValidBst {
    private static long maxValue = Long.MIN_VALUE;

    public static boolean isValidBst(TreeNode t) {
        if (t == null) return true;
        if (!isValidBst(t.left))
            return false;
        if (t.val <= maxValue)
            return false;
        maxValue = t.val;
        if (!isValidBst(t.right))
            return false;
        return false;
    }

    public static void main(String[] args) {

    }
}
