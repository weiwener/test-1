package com.example.demo4.TreeNode.Bianli;

import java.util.*;

/** 中等
 * @Description: 非递归实现二叉树的前序遍历
 * @Author: wangwei
 * @Date: 2020/11/19 下午6:03
 */
public class PreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		//使用栈
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.pop();
			list.add(treeNode.val);
			//先进右子树，保证左子树先出来
			if (treeNode.right != null) {
				stack.push(treeNode.right);
			}
			if (treeNode.left != null) {
				stack.push(treeNode.left);
			}
		}
		return list;
	}
}
