package com.example.demo4.Strings;

import java.math.BigInteger;
import java.util.Objects;

/** 中等
 * @Description: 把字符串转换成整数
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 *
 *  
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为[−2^31, 2^31− 1]。如果数值超过这个范围，请返回INT_MAX (231− 1) 或INT_MIN (−231) 。
 *
 * 示例1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−231)
 *
 * @Author: wangwei
 * @Date: 2020/10/28 下午3:48
 */
public class StrToInt {
	public static int strToInt(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		int flag = 1, i = 0, result = 0;
		int length = str.length(), maxBiary = Integer.MAX_VALUE / 10;
		//判断空格
		while (str.charAt(i) == ' ') {
			if (++i == length) {
				return 0;
			}
		}
		//判断正负位
		if (str.charAt(i) == '-') {
			flag = -1;
			i++;
		} else if (str.charAt(i) == '+') {
			i++;
		}
		//计算绝对值大小
		for (int j = i; j < length; j++) {
			if (str.charAt(j) < '0' || str.charAt(j) > '9') {
				return result*flag;
			}
			if (result > maxBiary || (result == maxBiary && str.charAt(j) > '7')) {
				return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result * 10 + (str.charAt(j)-'0');
		}
		return result * flag;
	}

	public static void main(String[] args) {
//		Integer a=strToInt("42");
//		Integer b=strToInt("   -42");
//		Integer c=strToInt("4193 with words");
//		Integer d=strToInt("words and 987");
//		Integer e=strToInt("-91283472332");
//		Integer f=strToInt("+");

//		"2147483648"
//		输出：
//		-2147483648
//		预期结果：
//		2147483647
		Integer g=strToInt("2147483648");
		System.out.println(g);
	}


//	根据题意，有以下四种字符需要考虑：
//
//	首部空格：删除之即可；
//	符号位：三种情况，即 ''++'' , ''-−'' , ''无符号" ；新建一个变量保存符号位，返回前判断正负即可。
//	非数字字符： 遇到首个非数字的字符时，应立即返回。
//	数字字符：
//	字符转数字： “此数字的 ASCII 码” 与 “ 00 的 ASCII 码” 相减即可；
//	数字拼接： 若从左向右遍历数字，设当前位字符为 cc ，当前位数字为 xx ，数字结果为 resres ，则数字拼接公式为：


	/*class Solution {
		public int strToInt(String str) {
			char[] c = str.trim().toCharArray();
			if(c.length == 0) return 0;
			int res = 0, bndry = Integer.MAX_VALUE / 10;
			int i = 1, sign = 1;
			if(c[0] == '-') sign = -1;
			else if(c[0] != '+') i = 0;
			for(int j = i; j < c.length; j++) {
				if(c[j] < '0' || c[j] > '9') break;
				if(res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				res = res * 10 + (c[j] - '0');
			}
			return sign * res;
		}
	}
//	若不使用 trim() / strip() 方法，而从头开始遍历字符串，则可以将空间复杂度降低至 O(1)O(1) ，代码如下：


	class Solution {
		public int strToInt(String str) {
			int res = 0, bndry = Integer.MAX_VALUE / 10;
			int i = 0, sign = 1, length = str.length();
			if(length == 0) return 0;
			while(str.charAt(i) == ' ')
				if(++i == length) return 0;
			if(str.charAt(i) == '-') sign = -1;
			if(str.charAt(i) == '-' || str.charAt(i) == '+') i++;
			for(int j = i; j < length; j++) {
				if(str.charAt(j) < '0' || str.charAt(j) > '9') break;
				if(res > bndry || res == bndry && str.charAt(j) > '7')
					return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				res = res * 10 + (str.charAt(j) - '0');
			}
			return sign * res;
		}
	}


	class Solution {
		public int strToInt(String str) {
			if (str == null || str.length() == 0) {
				return 0;
			}
			long res = 0;
			char zero = '0';
			char blank = ' ';
			char minus = '-';
			char plus = '+';
			boolean minusFlag = false;
			boolean operatorFlag = false;
			for (int i = 0; i < str.length(); i ++) {
				char d = str.charAt(i);
				if (!operatorFlag && blank == d) {
					continue;
				}
				if (!operatorFlag && minus == d) {
					minusFlag = true;
					operatorFlag = true;
					continue;
				}
				if (!operatorFlag && plus == d) {
					operatorFlag = true;
					continue;
				}
				long sub = d - zero;
				if (sub < 0 || sub > 9) {
					break;
				}
				res = res * 10 + sub;
				operatorFlag = true;
				if (minusFlag && -res < Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
				if (!minusFlag && res > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				}
			}
			res = minusFlag ? -res : res;
			return (int) res;
		}
	}*/



}
