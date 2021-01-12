package com.example.demo4.TreeNode.Bianli;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/** 中等
 * @Description: 找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出:
 * 1
 *
 * 示例 2:
 * 输入:
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 * 输出:
 * 7
 * @Author: wangwei
 * @Date: 2020/11/19 下午3:57
 */
public class FindBottomLeftValue {
	public int findBottomLeftValue(TreeNode root) {
		if (root == null) {
			return -1;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int result = root.val;
		while (!queue.isEmpty()) {
			int length = queue.size();
			result = queue.peek().val;
			for (int i = 0; i < length; i++) {
				TreeNode treeNode = queue.poll();
				if (treeNode.left != null) {
					queue.add(treeNode.left);
				}
				if (treeNode.right != null) {
					queue.add(treeNode.right);
				}
			}
		}
		return result;

		//官方答案，代码更简单，只不过需稍微理解下
		/*Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			root = queue.poll();
			if (root.right != null) queue.add(root.right);
			if (root.left != null) queue.add(root.left);
		}
		return root.val;*/
	}
}
