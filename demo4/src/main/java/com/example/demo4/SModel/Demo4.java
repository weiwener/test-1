package com.example.demo4.SModel;

/**
 * @Description: 枚举单例类
 * @Author: wangwei
 * @Date: 2020/12/18 下午4:15
 */
public class Demo4 {
	public static Demo4 getInstance() {
		return Demo.INSTANCE.getInstance();
	}

	public static void main(String[] args) {
		Demo4 s1 = Demo4.getInstance();
		Demo4 s2 = Demo4.getInstance();
		System.out.println(s1 == s2);
	}

	//定义枚举
	private static enum Demo {
		INSTANCE;
		// 枚举元素为单例
		private Demo4 demo4;

		private Demo() {
			System.out.println("枚举Demo私有构造参数");
			demo4 = new Demo4();
		}

		public Demo4 getInstance() {
			return demo4;
		}
	}
}
