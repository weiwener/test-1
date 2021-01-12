package com.example.demo4.TreeNode.Digui;

/** 简单
 * @Description:  翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * @Author: wangwei
 * @Date: 2020/11/18 上午10:55
 */
public class InvertTree {
	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode left=root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(left);
		return root;
	}

	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(4);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(7);
		TreeNode r4 = new TreeNode(1);
		TreeNode r5 = new TreeNode(3);
		TreeNode r6 = new TreeNode(6);
		TreeNode r7 = new TreeNode(9);
		r1.left = r2;
		r1.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = r6;
		r3.right = r7;
		TreeNode root = invertTree(r1);
	}
}
