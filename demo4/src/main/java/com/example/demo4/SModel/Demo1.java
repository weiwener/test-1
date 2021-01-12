package com.example.demo4.SModel;

/**
 * @Description: 饿汉式
 * @Author: wangwei
 * @Date: 2020/12/18 下午4:10
 */
public class Demo1 {
	private static Demo1 demo1 = new Demo1();
	private Demo1() {
		System.out.println("私有Demo1构造参数初始化");
	}

	public static Demo1 getInstance() {
		return demo1;
	}

	public static void main(String[] args) {
		Demo1 s1 = Demo1.getInstance();
		Demo1 s2 = Demo1.getInstance();
		System.out.println(s1 == s2);
	}
}
