package com.example.demo4.TreeNode.Digui;


import java.util.HashMap;
import java.util.Map;

/** 中等
 * @Description: 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 *
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @Author: wangwei
 * @Date: 2020/7/2 下午11:07
 */
public class BulidTree {

//	private Map<Integer,Integer> indexMap=new HashMap<>();
	public TreeNode buildTree(int[] preorder, int[] inorder) {
//		if(preorder==null||preorder.length==0){
//			return null;
//		}
//		for(int i=0;i<inorder.length;i++){
//			indexMap.put(inorder[i],i);
//		}
//		return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
//
//

		if (preorder == null || preorder.length == 0) {
			return null;
		}
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		int length = preorder.length;
		for (int i = 0; i < length; i++) {
			indexMap.put(inorder[i], i);
		}
		TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
		return root;
	}

	public static TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd,
									 Map<Integer, Integer> indexMap) {
		if (preorderStart > preorderEnd) {
			return null;
		}
		int rootVal = preorder[preorderStart];
		TreeNode root = new TreeNode(rootVal);
		if (preorderStart == preorderEnd) {
			return root;
		} else {
			int rootIndex = indexMap.get(rootVal);
			int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
			root.left = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
			root.right = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
			return root;
		}
	}

//	public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
//		if (preStart > preEnd) {
//			return null;
//		}
//		int rootVal = preorder[preStart];
//		TreeNode root = new TreeNode(rootVal);
//		if (preStart == preEnd) {
//			return root;
//		}
//		int rootIndex = indexMap.get(rootVal);
//		int leftNodes = rootIndex - inStart, rightNodes = inEnd - rootIndex;
//		root.left = buildTree(preorder, preStart + 1, preStart + leftNodes, inorder, inStart + 1, inStart + leftNodes);
//		root.right = buildTree(preorder, preEnd - rightNodes + 1, preEnd, inorder, rootIndex + 1, inEnd);
//		return root;
//	}

	// 优化解法
	// 缓存中序遍历数组每个值对应的索引
	private Map<Integer, Integer> indexForInOrders = new HashMap<>();

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		for (int i = 0; i < in.length; i++) {
			indexForInOrders.put(in[i], i);
		}
		return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
	}

	private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
		if (preL > preR) {
			return null;
		}
		TreeNode root = new TreeNode(pre[preL]);
		int inIndex = indexForInOrders.get(root.val);
		int leftTreeSize = inIndex - inL;
		root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
		root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
		return root;
	}

	public static void main(String[] args) {
		int []preorder = new int[]{3,9,20,15,7};
		int []inorder = new int[]{9,3,15,20,7};
//		TreeNode treeNode=buildTree(preorder,inorder);
	}

}
