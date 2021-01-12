package com.example.demo4.TreeNode.Digui;

/** 简单
 * @Description: 二叉树中第二小的节点
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5
 *
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值
 * @Author: wangwei
 * @Date: 2020/11/19 下午12:50
 */
public class FindSecondMinimumValue {
	public int findSecondMinimumValue(TreeNode root) {
		//不太懂
		if (root == null) {return -1;}
		if (root.left == null && root.right == null) {return -1;}
		int leftVal = root.left.val;
		int rightVal = root.right.val;
		if (leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
		if (rightVal == root.val) rightVal = findSecondMinimumValue(root.right);
		if (leftVal != -1 && rightVal != -1) return Math.min(leftVal, rightVal);
		if (leftVal != -1) return leftVal;
		return rightVal;
	}
}
