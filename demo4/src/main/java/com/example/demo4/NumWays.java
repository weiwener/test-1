package com.example.demo4;

/** 简单
 *
 * @Description: 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 * @Author: wangwei
 * @Date: 2020/11/11 下午4:34
 */
public class NumWays {
	// f(n)=f(n-1)+f(n-2)
	public int numWays(int n) {
		if (n <= 0 || n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int first = 1, second = 2, third = 0;
		for (int i = 3; i <= n; i++) {
			third = (first + second) % 1000000007;
			first = second;
			second = third;
		}

		return third;
	}
}
