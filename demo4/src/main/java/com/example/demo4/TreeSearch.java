package com.example.demo4;

import java.util.Arrays;

/**
 * @Description:
 * @Author: wangwei
 * @Date: 2020/7/5 下午5:31
 */
public class TreeSearch {
	public static boolean verifyPostorder(int[] postorder) {
		if(postorder==null){
			return false;
		}
		return valite(postorder);
	}

	public static boolean valite(int[] nums) {
		if (nums.length == 0) {
			return true;
		}
		int rootVal = nums[nums.length - 1];
		int i = 0;
		while (nums[i] < rootVal) {
			i++;
		}
		int[] left = Arrays.copyOfRange(nums, 0, i);
		int[] right = Arrays.copyOfRange(nums, i, nums.length - 1);


		if(right.length == 0){
			return true && valite(left);
		}else{
			int j = 0;
			while (j < right.length) {
				if (right[j] > rootVal) {
					j++;
				} else {
					break;
				}
			}
			if (j == right.length) {
				return true && valite(left) && valite(right);
			} else {
				return false;
			}
		}


	}

	public static void main(String[] args) {
		int []nums=new int[]{7, 4, 6, 5};
		Boolean result=verifyPostorder(nums);
		System.out.println(result);
	}
}
