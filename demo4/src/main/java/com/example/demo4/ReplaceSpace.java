package com.example.demo4;

import java.util.Objects;

/**
 * @Description: 替换空格
 * 把字符串 s 中的每个空格替换成"%20"。
 * 示例
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * @Author: wangwei
 * @Date: 2020/10/19 下午2:46
 */
public class ReplaceSpace {
	public static String replaceSpace(String s) {
		StringBuilder stringBuffer = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (Objects.equals(s.charAt(i), ' ')) {
				stringBuffer.append("%20");
			} else {
				stringBuffer.append(s.charAt(i));
			}
		}
		return stringBuffer.toString();
	}

	public static void main(String[] args) {
		String s="We are happy.";
		replaceSpace(s);
	}
}

/*另一种解法*/

/*
class Solution {
	public String replaceSpace(String s) {
		int length = s.length();
		char[] array = new char[length * 3];
		int size = 0;
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				array[size++] = '%';
				array[size++] = '2';
				array[size++] = '0';
			} else {
				array[size++] = c;
			}
		}
		String newStr = new String(array, 0, size);
		return newStr;
	}
}*/
