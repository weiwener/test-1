package com.example.demo4.TreeNode.BST;

/**简单
 * @Description: 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * @Author: wangwei
 * @Date: 2020/11/20 下午5:46
 */
public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null) {
			return null;
		}
		return toBST(nums, 0, nums.length - 1);
	}

	private TreeNode toBST(int[] nums, int sIdx, int eIdx) {
		if (sIdx > eIdx) {
			return null;
		}
		int midIds = (sIdx + eIdx) / 2;
		TreeNode root = new TreeNode(nums[midIds]);
		root.left = toBST(nums, sIdx, midIds - 1);
		root.right = toBST(nums, midIds + 1, eIdx);
		return root;
	}
}
