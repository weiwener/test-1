package com.example.demo4.TIJIE;


import java.util.*;

/**
 * @Description:
 * @Author: wangwei
 * @Date: 2021/1/10 下午3:55
 */
public class JZSoution {
	/*剑指 Offer 10- I. 斐波那契数列
	写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：

	F(0) = 0,   F(1) = 1
	F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
	斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

	答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
示例 1：

	输入：n = 2
	输出：1
	示例 2：

	输入：n = 5
	输出：5*/
	public int fib(int n) {
		if(n<=0){
			return 0;
		}
		if(n==1||n==2){
			return 1;
		}
		int first=1,second=1,third=0;
		for(int i=3;i<=n;i++){
			third=(first+second)%1000000007;
			first=second;
			second=third;
		}

		return third;
	}

	/*剑指 Offer 09. 用两个栈实现队列
	用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
    */
	//奇偶数排序
	public int[] exchange(int[] nums) {
		if (nums == null || nums.length == 0)
			return nums;
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			while (left < right && (nums[left] & 1) == 1) {
				left++;
			}
			while (left < right && (nums[right] & 1) == 0) {
				right--;
			}
			if (left < right) {
				nums[left] ^= nums[right];
				nums[right] ^= nums[left];
				nums[left] ^= nums[right];
			}
		}
		return nums;
	}

	/*剑指 Offer 29. 顺时针打印矩阵
	输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
示例 1：
	输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
	输出：[1,2,3,6,9,8,7,4,5]
	示例 2：

	输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
	输出：[1,2,3,4,8,12,11,10,9,5,6,7]*/
	class Solution {
		public int[] spiralOrder(int[][] matrix) {
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
				return new int[0];
			}
			int rows = matrix.length, columns = matrix[0].length;
			int[] order = new int[rows * columns];
			int index = 0;
			int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
			while (left <= right && top <= bottom) {
				for (int column = left; column <= right; column++) {
					order[index++] = matrix[top][column];
				}
				for (int row = top + 1; row <= bottom; row++) {
					order[index++] = matrix[row][right];
				}
				if (left < right && top < bottom) {
					for (int column = right - 1; column > left; column--) {
						order[index++] = matrix[bottom][column];
					}
					for (int row = bottom; row > top; row--) {
						order[index++] = matrix[row][left];
					}
				}
				left++;
				right--;
				top++;
				bottom--;
			}
			return order;
		}
	}

	/*剑指 Offer 46. 把数字翻译成字符串
	给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
示例 1:
	输入: 12258
	输出: 5
	解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"*/
	//动态规划
	public int translateNum(int num) {
		String s=String.valueOf(num);
		int a=1,b=1;
		for(int i=2;i<=s.length();i++){
			String tmp=s.substring(i-2,i);
			int c=tmp.compareTo("10")>=0&&tmp.compareTo("25")<=0?a+b:a;
			b=a;
			a=c;
		}
		return a;
	}

	/*剑指 Offer 64. 求1+2+…+n
	求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
示例 1：
	输入: n = 3
	输出: 6
	示例 2：
	输入: n = 9
	输出: 45*/
	public int sumNums(int n) {
		boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
		return n;
	}

	/*剑指 Offer 53 - II. 0～n-1中缺失的数字
	一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
示例 1:
	输入: [0,1,3]
	输出: 2
	示例 2:

	输入: [0,1,2,3,4,5,6,7,9]
	输出: 8*/
	public int missingNumber(int[] nums) {
		int i = 0, j = nums.length - 1;
		while(i <= j) {
			int m = (i + j) / 2;
			if(nums[m] == m) {
				i = m + 1;
			}
			else {
				j = m - 1;
			}
		}
		return i;
	}

/*	剑指 Offer 07. 重建二叉树
	输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如，给出
	前序遍历 preorder = [3,9,20,15,7]
	中序遍历 inorder = [9,3,15,20,7]
	返回如下的二叉树：

			3
			/ \
			9  20
			/  \
			15   7*/
public TreeNode buildTree(int[] preorder, int[] inorder) {
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

	//队列的最大值，维护一个单调的双端队列

	/*剑指 Offer 27. 二叉树的镜像
	请完成一个函数，输入一个二叉树，该函数输出它的镜像。

	例如输入：

			4
			/   \
			2     7
			/ \   / \
			1   3 6   9
	镜像输出：

			4
			/   \
			7     2
			/ \   / \
			9   6 3   1
*/
	public TreeNode mirrorTree(TreeNode root) {
		if(root==null){
			return root;
		}
		TreeNode temp=root.left;
		root.left=mirrorTree(root.right);
		root.right=mirrorTree(temp);
		return root;
	}

	//辅助栈
	public TreeNode mirrorTree1(TreeNode root) {
		if(root == null) return null;
		Stack<TreeNode> stack = new Stack<TreeNode>() {{ add(root); }};
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if(node.left != null) stack.add(node.left);
			if(node.right != null) stack.add(node.right);
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
		}
		return root;
	}

	/*剑指 Offer 14- I. 剪绳子
	给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
	例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
	示例 1：
	输入: 2
	输出: 1
	解释: 2 = 1 + 1, 1 × 1 = 1
	示例 2:

	输入: 10
	输出: 36
	解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36*/
	//贪心算法
	public int cuttingRope(int n) {
		if(n <= 3) return n - 1;
		int a = n / 3, b = n % 3;
		if(b == 0) return (int)Math.pow(3, a);
		if(b == 1) return (int)Math.pow(3, a - 1) * 4;
		return (int)Math.pow(3, a) * 2;
	}

	/*剑指 Offer 68 - II. 二叉树的最近公共祖先
	给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
	百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
	例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
    */
	private TreeNode ans;
	private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return false;
		boolean lson = dfs(root.left, p, q);
		boolean rson = dfs(root.right, p, q);
		if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
			ans = root;
		}
		return lson || rson || (root.val == p.val || root.val == q.val);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		this.dfs(root, p, q);
		return this.ans;
	}


	/*剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
	给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

	百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    */
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode ancestor = root;
		while (true) {
			if (p.val < ancestor.val && q.val < ancestor.val) {
				ancestor = ancestor.left;
			} else if (p.val > ancestor.val && q.val > ancestor.val) {
				ancestor = ancestor.right;
			} else {
				break;
			}
		}
		return ancestor;
	}

	/*剑指 Offer 34. 二叉树中和为某一值的路径
	输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
	示例:
	给定如下二叉树，以及目标和 sum = 22，
			5
			/ \
			4   8
			/   / \
			11  13  4
			/  \    / \
			7    2  5   1
	返回:

			[
			[5,4,11,2],
			[5,8,4,5]
			]*/

	//应该使用到回溯法了
	LinkedList<List<Integer>> res = new LinkedList<>();
	LinkedList<Integer> path = new LinkedList<>();
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		recur(root, sum);
		return res;
	}
	void recur(TreeNode root, int tar) {
		if(root == null) return;
		path.add(root.val);
		tar -= root.val;
		if(tar == 0 && root.left == null && root.right == null){
			res.add(new LinkedList(path));
		}
		recur(root.left, tar);
		recur(root.right, tar);
		path.removeLast();
	}




}
