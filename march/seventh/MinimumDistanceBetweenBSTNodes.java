package LeetCoding.march.seventh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
 * @author rgk
 *
 */
public class MinimumDistanceBetweenBSTNodes {
	static private List<Integer> valueList = new ArrayList<>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode left1= new TreeNode(2);
		TreeNode right1= new TreeNode(6);
		TreeNode left11= new TreeNode(1);
		TreeNode left12= new TreeNode(3);
		
		root.left = left1;
		root.right = right1;
		left1.left = left11;
		left1.right = left12;
		
		DFS(root);
		
		Collections.sort(valueList);
		
		int minDiff = Integer.MAX_VALUE;
		int leftValue = valueList.get(0);
		for (int i = 1; i < valueList.size(); i++) {
			int value = valueList.get(i);
			int diff = Math.abs(value - leftValue);
			if (minDiff > diff) {
				minDiff = diff;
			}
			leftValue = value;
		}
		System.out.println(valueList);
		System.out.println(minDiff);
	}
	
	public static int minDiffInBST(TreeNode root) {
		int minDiff = 0;
		while(root.left != null) {
			if (minDiff > Math.abs(root.val - root.left.val))
				minDiff = Math.abs(root.val - root.left.val);
		}
		return 0;
    }
	
	private static void DFS(TreeNode node) {
		if(node != null) {
			valueList.add(node.val);
			DFS(node.left);
			DFS(node.right);
		}
	}
	
	public static class TreeNode {
		int val;
	 	TreeNode left;
	 	TreeNode right;
	 	TreeNode(int x) { val = x; }
	 }
}
