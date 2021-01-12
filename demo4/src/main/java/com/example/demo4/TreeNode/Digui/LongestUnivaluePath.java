package com.example.demo4.TreeNode.Digui;

/** 中等
 * @Description: 最长同值路径
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 * 示例 2:

 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 * 注意: 给定的二叉树不超过10000个结点。树的高度不超过1000。
 * @Author: wangwei
 * @Date: 2020/11/18 下午7:40
 */
public class LongestUnivaluePath {
	//和DiameterOfBinaryTree 这道题类似
	private int max=0;
	public int longestUnivaluePath(TreeNode root) {
		dfs(root);
		return max;
	}

	public int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = dfs(root.left);
		int right = dfs(root.right);
		int leftDfs = (root.left != null && root.val == root.left.val) ? left + 1 : 0;
		int rigthDfs = (root.right != null && root.val == root.right.val) ? right + 1 : 0;
		max = Math.max(max, leftDfs + rigthDfs);
		return Math.max(leftDfs, rigthDfs);
	}
}
