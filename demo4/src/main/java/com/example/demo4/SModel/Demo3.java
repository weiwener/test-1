package com.example.demo4.SModel;

/**
 * @Description: 静态内部类
 * @Author: wangwei
 * @Date: 2020/12/18 下午4:11
 */
public class Demo3 {
	private Demo3() {
		System.out.println("私有Demo3构造参数初始化");
	}

	public static class SingletonClassInstance {
		private static final Demo3 DEMO_3 = new Demo3();
	}

	// 方法没有同步
	public static Demo3 getInstance() {
		return SingletonClassInstance.DEMO_3;
	}

	public static void main(String[] args) {
		Demo3 s1 = Demo3.getInstance();
		Demo3 s2 = Demo3.getInstance();
		System.out.println(s1 == s2);
	}
}
