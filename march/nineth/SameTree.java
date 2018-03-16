package LeetCoding.march.nineth;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/same-tree/description/
 */
public class SameTree {
    private static List<TreeNode> treeNodeList = new ArrayList<>();
    public static void main(String[] args) {
//        TreeNode root1 = new TreeNode(1);
//        TreeNode root2 = new TreeNode(1);
//        TreeNode node11 = new TreeNode(2);
//        TreeNode node12 = new TreeNode(3);
//        TreeNode node21 = new TreeNode(2);
//        TreeNode node22 = new TreeNode(4);
//        root1.left = node11;
//        root1.right = node12;
//        root2.left = node21;
//        root2.right = node22;
//        System.out.println(isSameTree(root1, root2));

        TreeNode rootA = new TreeNode(1);
        TreeNode nodeA1 = new TreeNode(2);
        rootA.left = nodeA1;

        TreeNode rootB = new TreeNode(1);
        TreeNode nodeB2 = new TreeNode(2);
        rootB.left = null;
        rootB.right = nodeB2;
        System.out.println(isSameTree(rootA, rootB));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
