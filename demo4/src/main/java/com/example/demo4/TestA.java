package com.example.demo4;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: wangwei
 * @Date: 2019/8/27 上午10:59
 */
@Service
public class TestA {
	public static void main(String[] args) throws InterruptedException {
		final List<Integer> list = new ArrayList<Integer>(20);

		// 线程A将0-1000添加到list
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10 ; i++) {
					list.add(i);

					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		// 线程B将1000-2000添加到列表
		new Thread(new Runnable() {
			public void run() {
				for (int i = 10; i < 20 ; i++) {
					list.add(i);

					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		Thread.sleep(1000);

		// 打印所有结果
		for (int i = 0; i < list.size(); i++) {
			System.out.println("第" + (i + 1) + "个元素为：" + list.get(i));
		}
	}
}
