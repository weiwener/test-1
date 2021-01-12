package com.example.demo;

/**
 * @Description:
 * @Author: wangwei
 * @Date: 2020/12/25 下午4:50
 */
class SingletonLL {
	//在这里第一层空判断是为了减少锁控制的粒度，使用volatile修饰是因为在jvm中new Singleton()会出现指令重排，volatile避免happens before，避免空指针的问题。
	private static volatile SingletonLL singleton;
	private SingletonLL(){};
	public SingletonLL getSingleton(){
		if(null == singleton){
			synchronized(SingletonLL.class){
				if(null == singleton){
					singleton = new SingletonLL();
				}
			}
		}
		return singleton;
	}
}
