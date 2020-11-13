package com.example.demo4;

/** 中等
 * @Description: 数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * @Author: wangwei
 * @Date: 2020/11/11 下午11:04
 */
public class MyPow {
	public static double myPow(double x, int n) {
		if (x == 0) return 0;
		long b = n;
		double res = 1.0;
		if (b < 0) {
			x = 1 / x;
			b = -b;
		}
		while (b > 0) {
			if ((b & 1) == 1) res *= x;
			x *= x;
			b >>= 1;
		}
		return res;

		/*//此方法超时
		double res=1;
		if(x>0){
			int rn=n>0?n:n*(-1);
			for(int i=0;i<rn;i++){
				res=res*x;
			}
			if(n>0){
				return res;
			}else{
				return 1/res;
			}
		}

		if(x<0){
			for(int i=0;i<n;i++){
				res=res*x;
			}
			if(n>0){
				return res;
			}else{
				return 1/res;
			}
		}
		return res;*/
	}

	public static void main(String[] args) {
		double a1 = myPow(2.00000, 10);
		double a2 = myPow(2.10000, 3);
		double a3 = myPow(2.00000, -2);
		System.out.println(a1 + " " + a2 + " " + a3 );
	}
}
