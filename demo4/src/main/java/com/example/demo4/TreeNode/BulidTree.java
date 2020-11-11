package com.example.demo4.TreeNode;

import com.example.demo4.TreeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wangwei
 * @Date: 2020/7/2 下午11:07
 */
public class BulidTree {
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
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
			TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
			TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
			root.left = leftSubtree;
			root.right = rightSubtree;
			return root;
		}
	}


	public static void main(String[] args) {
		int []preorder = new int[]{3,9,20,15,7};
		int []inorder = new int[]{9,3,15,20,7};
		TreeNode treeNode=buildTree(preorder,inorder);
	}

}
