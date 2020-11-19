package com.example.demo4.TreeNode;

/** 中等
 * @Description: 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 * @Author: wangwei
 * @Date: 2020/11/18 下午2:33
 */
public class PathSum {
	/*本题需要去计算路径和等于给定数值的路径总数，我们依旧遵循树模型的解题思路，按照递归的方式去求解（递归的一个重要思想就是两部分：
	1.找到最简单的子问题求解，2.其他问题不考虑内在细节，只考虑整体逻辑），那我们现在来设计递归关系：
    首先，最简单的子问题是什么呢？由于这道题是在树的框架下，我们最容易想到的就是遍历的终止条件：
    if(root == null){
		return 0;
	}
	接下来，我们来考虑再上升的一个层次，题目要求 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点） 。
	这就要求我们只需要去求三部分即可：
    以当前节点作为头结点的路径数量
	以当前节点的左孩子作为头结点的路径数量
	以当前节点的右孩子作为头结点啊路径数量
	将这三部分之和作为最后结果即可。

	最后的问题是：我们应该如何去求以当前节点作为头结点的路径的数量？这里依旧是按照树的遍历方式模板，每到一个节点让sum-root.val，并判断sum是否为0，如果为零的话，则找到满足条件的一条路径。
	*/
	public static int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		return pathSumStartWithRoot(root, sum) + pathSumStartWithRoot(root.left, sum) + pathSumStartWithRoot(root.right, sum);
	}

	public static int pathSumStartWithRoot(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		int count = 0;
		int val = root.val;
		if (val == sum) {
			count++;
		}
		return count + pathSumStartWithRoot(root.left, sum - val) + pathSumStartWithRoot(root.right, sum - val);
	}

	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		TreeNode root1=new TreeNode(3);
		TreeNode root2=new TreeNode(1);
		TreeNode root3=new TreeNode(2);
		root.left=root1;
		root.right=root2;
		root2.right=root3;
		int count=pathSum(root,3);
		System.out.println(count);
	}
}
