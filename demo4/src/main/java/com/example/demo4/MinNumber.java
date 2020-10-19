package com.example.demo4;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Description: 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 * @Author: wangwei
 * @Date: 2020/7/20 下午1:12
 */
public class MinNumber {
	/*输入: [10,2]
	输出: "102"
	示例 2:

	输入: [3,30,34,5,9]
	输出: "3033459"*/

	public static String minNumber(int[] nums) {

		String[] strs = new String[nums.length];
		for(int i = 0; i < nums.length; i++){
			strs[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
		StringBuilder res = new StringBuilder();
		for(String s : strs){
			res.append(s);
		}
		return res.toString();
	}

	public static void main(String[] args) {
		int []num1=new int[]{10,2};
		int []num2=new int[]{3,30,34,5,9};
		System.out.println(minNumber(num1));
		System.out.println(minNumber(num2));
	}

}
