package com.example.demo4.TreeNode.Digui;

/** 简单
 * @Description: 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]
 * 注意：两结点之间的路径长度是以它们之间边的数目表示
 * @Author: wangwei
 * @Date: 2020/11/17 下午7:19
 */
public class DiameterOfBinaryTree {
	private static int max = 0;

	public static int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return max;
	}

	private static int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = depth(root.left);
		int rightDepth = depth(root.right);
		max = Math.max(max, leftDepth + rightDepth);
		return Math.max(leftDepth, rightDepth) + 1;
	}

	public static void main(String[] args) {
		TreeNode r1=new TreeNode(1);
		TreeNode r2=new TreeNode(2);
		TreeNode r3=new TreeNode(3);
		TreeNode r4=new TreeNode(4);
		TreeNode r5=new TreeNode(5);
		r1.left=r2;
		r2.left=r4;
		r2.right=r5;
		r1.right=r3;
		int res=diameterOfBinaryTree(r1);

	}
}
