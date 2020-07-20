package com.example.demo;

/**
 * @Description: 懒汉式单例
 * @Author: wangwei
 * @Date: 2020/3/30 下午10:52
 */
public class SingletonL {
	private static SingletonL instance = null;
	private SingletonL() {}
	public static synchronized SingletonL getInstance(){
		if (instance == null) {
			instance = new SingletonL();
		}
		return instance;
	}
}
