package com.example.demo4.TIJIE;

/**
 * @Description: 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * @Author: wangwei
 * @Date: 2020/11/22 下午10:18
 */
public class Reverse7 {
	public int reverse(int x) {
		int res=0;
		while(x!=0){
			int pop=x%10;
			x=x/10;
			if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&pop>7)){
				return 0;
			}
			if(res<Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE/10&&pop<-8)){
				return 0;
			}
			res=res*10+pop;
		}
		return res;
	}
}
