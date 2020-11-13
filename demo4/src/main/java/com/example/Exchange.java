package com.example;

/** 简单
 * @Description: 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 示例：
 *
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * @Author: wangwei
 * @Date: 2020/11/12 下午7:13
 */
public class Exchange {
	public int[] exchange(int[] nums) {
		if (nums == null || nums.length == 0) {
			return nums;
		}
		int left = 0, right = nums.length - 1, temp = 0;
		while (left < right) {
			while (left < right && (nums[left] & 1) == 1) {
				left++;
			}
			while (left < right && (nums[right] & 1) == 0) {
				right--;
			}
			temp = nums[right];
			nums[right] = nums[left];
			nums[left] = temp;
		}


//		int curIndex = 0;
//		int length = nums.length;
//		for (int i = 0; i < length; i++) {
//			if ((nums[i] & 1) == 1) {   // 当前数字为 奇数
//                /*
//                    交换 当前遍历到的数字 和 当前未排序列的第一个元素
//                 */
//				int temp = nums[i];
//				nums[i] = nums[curIndex];
//				nums[curIndex++] = temp;
//			}
//		}


		return nums;
	}
}
