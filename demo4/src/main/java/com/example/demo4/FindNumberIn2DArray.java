package com.example.demo4;

/** 中等
 * @Description: 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 *
 * 给定target=20，返回false
 * @Author: wangwei
 * @Date: 2020/11/11 下午5:20
 */
public class FindNumberIn2DArray {
	public static boolean findNumberIn2DArray(int[][] matrix, int target) {
		if (matrix == null || matrix.length <= 0) {
			return false;
		}
		//行 列
		int row = matrix.length, col = matrix[0].length;
		//从左下角开始
		int i = row - 1, j = 0;
		while (i >= 0 && j < col) {
			if (matrix[i][j] == target) {
				return true;
			}
			if (matrix[i][j] < target) {
				j++;
			} else {
				i--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] nums=new int[1][2];
		nums[0][0]=1;
		nums[0][1]=1;
		boolean res=findNumberIn2DArray(nums,0);
	}
}
