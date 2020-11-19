package com.example.demo4.TreeNode;

/** 简单
 * @Description: 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false
 * @Author: wangwei
 * @Date: 2020/11/18 下午5:09
 */
public class IsSubtree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null) {
			return false;
		}
		return isSub(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	public boolean isSub(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		if (s.val != t.val) {
			return false;
		}
		return isSub(s.left, t.left) && isSub(s.right, t.right);
	}
}
