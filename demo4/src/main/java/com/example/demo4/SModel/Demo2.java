package com.example.demo4.SModel;

/**
 * @Description: 懒汉式
 * @Author: wangwei
 * @Date: 2020/12/18 下午4:10
 */
public class Demo2 {
	//类初始化时，不会初始化该对象，真正需要使用的时候才会创建该对象。
	private static Demo2 demo2;

	private Demo2() {
		System.out.println("私有Demo2构造参数初始化");
	}

	public synchronized static Demo2 getInstance() {
		if (demo2 == null) {
			demo2 = new Demo2();
		}
		return demo2;
	}

	public static void main(String[] args) {
		Demo2 s1 = Demo2.getInstance();
		Demo2 s2 = Demo2.getInstance();
		System.out.println(s1 == s2);
	}
}
