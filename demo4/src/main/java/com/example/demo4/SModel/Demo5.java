package com.example.demo4.SModel;

/**
 * @Description: 双重检索方式
 * @Author: wangwei
 * @Date: 2020/12/18 下午4:19
 */
public class Demo5 {
	private static Demo5 demo5;

	private Demo5() {
		System.out.println("私有Demo4构造参数初始化");
	}

	public static Demo5 getInstance() {
		if (demo5 == null) {
			synchronized (Demo5.class) {
				if (demo5 == null) {
					demo5 = new Demo5();
				}
			}
		}
		return demo5;
	}

	public static void main(String[] args) {
		Demo5 s1 = Demo5.getInstance();
		Demo5 s2 = Demo5.getInstance();
		System.out.println(s1 == s2);
	}
}
