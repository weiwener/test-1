package com.example.demo4.TreeNode.Bianli;

import java.util.*;

/** 简单
 * @Description: 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * 示例 1：
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 * @Author: wangwei
 * @Date: 2020/11/19 下午1:01
 */
public class AverageOfLevels {
	public List<Double> averageOfLevels(TreeNode root) {
		//queue实现先进先出
		List<Double> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) {
			return list;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			double sum = 0;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode treeNode = queue.poll();
				sum += treeNode.val;
				if (treeNode.left != null) {
					queue.add(treeNode.left);
				}
				if (treeNode.right != null) {
					queue.add(treeNode.right);
				}
			}
			list.add(sum / size);
		}
		return list;
	}


}
