package com.example.demo4.TreeNode.Bianli;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 二叉树的中序遍历 左根右
 * @Author: wangwei
 * @Date: 2020/11/19 下午10:35
 */
public class InorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if (root == null) return ret;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			TreeNode node = stack.pop();
			ret.add(node.val);
			cur = node.right;
		}
		return ret;
	}
}
