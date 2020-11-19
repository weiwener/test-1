package com.example.demo4.TreeNode;

/** 简单
 * @Description: 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 *
 * 输入：root = []
 * 输出：true

 * @Author: wangwei
 * @Date: 2020/11/17 下午6:54
 */
public class IsBalanced {
	public boolean isBalance = true;
	public boolean isBalanced(TreeNode root) {
		depth(root);
		return isBalance;
	}

	public int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = 1 + depth(root.left);
		int right = 1 + depth(root.right);
		if (Math.abs(left - right) > 1) {
			isBalance = false;
		}
		return Math.max(left, right);
	}

	//code答案
	public boolean isBalanced1(TreeNode root) {
		return height(root) >= 0;
	}

	public int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

}
