package com.example.demo4;

/**
 * @Description: 模拟StackOverFlowError
 * @Author: wangwei
 * @Date: 2019/12/18 下午8:33
 */
public class TestB {
	private static int index = 1;

	public static void main(String[] args){
		try {
			method();
		} catch (StackOverflowError e) {
			System.out.println("程序所需要的栈大小 > 允许最大的栈大小，执行深度: " + index);
			e.printStackTrace();
		}
	}

	private static void method() {
		index++;
		method();
	}

	//谨慎使用递归调用,确保需要有终止条件

}
