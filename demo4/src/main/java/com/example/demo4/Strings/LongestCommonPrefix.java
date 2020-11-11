package com.example.demo4.Strings;

/**
 * @Description: 最长公共前缀
 *编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 * @Author: wangwei
 * @Date: 2020/10/19 下午3:43
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String result = strs[0];
		for (int i = 1; i < strs.length; i++) {
			result = longPub(result, strs[i]);
			if (result.length() == 0) {
				return result;
			}
		}
		return result;
	}

	public String longPub(String str1, String str2) {
		int maxLength = Math.min(str1.length(), str2.length());
		int index = 0;
		while (index < maxLength && str1.charAt(index) == str2.charAt(index)) {
			index++;
		}
		return str1.substring(0, index);
	}

	public static void main(String[] args) {

	}
}
