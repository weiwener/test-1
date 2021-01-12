package com.example.demo4.TreeNode.Bianli;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/** 中等
 * @Description: 二叉树的后序遍历
 * 给定一个二叉树，返回它的后序遍历
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * @Author: wangwei
 * @Date: 2020/11/19 下午7:41
 */
public class PostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.pop();
			int val = treeNode.val;
			list.add(val);
			if (root.left != null) {
				stack.push(treeNode.left);
			}
			if (root.right != null) {
				stack.push(treeNode.right);
			}
		}
		Collections.reverse(list);
		return list;
	}
}
