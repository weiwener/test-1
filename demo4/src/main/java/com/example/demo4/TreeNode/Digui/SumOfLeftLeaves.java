package com.example.demo4.TreeNode.Digui;

/** 简单
 * @Description: 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * @Author: wangwei
 * @Date: 2020/11/18 下午7:18
 */
public class SumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
		//自己写的
		if (root == null) {
			return 0;
		}
		int val = 0;
		if (root.left != null && root.left.left == null && root.left.right == null) {
			val = root.left.val;
		}
		return val + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}

//	public int sumOfLeftLeaves(TreeNode root) {
//		if (root == null) return 0;
//		if (isLeaf(root.left)) return root.left.val + sumOfLeftLeaves(root.right);
//		return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
//	}
//
//	private boolean isLeaf(TreeNode node){
//		if (node == null) return false;
//		return node.left == null && node.right == null;
//	}
}
