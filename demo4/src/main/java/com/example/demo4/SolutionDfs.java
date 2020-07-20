package com.example.demo4;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: wangwei
 * @Date: 2020/7/4 下午9:59
 */
public class SolutionDfs {
	static LinkedList<List<Integer>> res = new LinkedList<>();
	static LinkedList<Integer> path = new LinkedList<>();
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		recur(root, sum);
		return res;
	}
	static void recur(TreeNode root, int tar) {
		if(root == null) return;
		path.add(root.val);
		tar -= root.val;
		if(tar == 0 && root.left == null && root.right == null)
			res.add(new LinkedList(path));
		recur(root.left, tar);
		recur(root.right, tar);
		path.removeLast();
	}

	public static void main(String[] args) {
		TreeNode treeNode=new TreeNode(5);
		TreeNode treeNode1=new TreeNode(4);
		TreeNode treeNode2=new TreeNode(11);
		TreeNode treeNode3=new TreeNode(7);
		TreeNode treeNode4=new TreeNode(2);
		TreeNode treeNode5=new TreeNode(5);
		TreeNode treeNode6=new TreeNode(13);
		TreeNode treeNode7=new TreeNode(8);
		TreeNode treeNode8=new TreeNode(5);
		TreeNode treeNode9=new TreeNode(1);
		treeNode.left=treeNode1;
		treeNode.right=treeNode5;
		treeNode1.left=treeNode2;
		treeNode1.right=null;
		treeNode2.left=treeNode3;
		treeNode2.right=treeNode4;
		treeNode3.left=null;
		treeNode3.right=null;
		treeNode4.left=null;treeNode4.right=null;
		treeNode5.left=treeNode6;
		treeNode5.right=treeNode7;
		treeNode6.left=null;
		treeNode6.right=null;
		treeNode7.left=treeNode8;
		treeNode7.right=treeNode9;
		treeNode8.left=null;
		treeNode8.right=null;
		treeNode9.left=null;
		treeNode9.right=null;
		pathSum(treeNode,22);

	}


}
