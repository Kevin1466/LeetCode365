package src.september;

public class LC687 {

    public static void main(String[] args) {
        LC687 lc = new LC687();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        System.out.println(lc.longestUnivaluePath(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }}

    /**
     * https://www.cnblogs.com/grandyang/p/7636259.html
      * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        dfs(root, res);
        return res;
    }

    private int dfs(TreeNode node, Integer count) {
        if (node == null) return 0;
        int left = dfs(node.left, count);
        int right = dfs(node.right, count);
        left = (node.left != null && node.val == node.left.val) ? left+1:0;
        right = (node.right != null && node.val == node.right.val) ? right+1:0;
        count = Math.max(count, left+right);
        return Math.max(left, right);
    }
}
