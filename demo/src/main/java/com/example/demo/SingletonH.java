package com.example.demo;

/**
 * @Description:  饿汉式单例
 * @Author: wangwei
 * @Date: 2020/3/30 下午10:51
 */
public class SingletonH {
	private SingletonH(){}
	private static SingletonH instance = new SingletonH();
	public static SingletonH getInstance(){
		return instance;
	}
}
