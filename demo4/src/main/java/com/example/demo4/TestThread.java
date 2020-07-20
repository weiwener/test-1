package com.example.demo4;

/**
 * @Description:
 * @Author: wangwei
 * @Date: 2020/6/7 下午5:04
 */
public class TestThread {

	public static void main(String[] args) {
		int[] nums1 = {1, 3, 5, 7, 9};
		int[] nums2 = {2, 4, 6, 8, 10};
		Object obj = new Object();

		Thread t1 = new Thread(() -> {
			synchronized (obj) {
				for (int n : nums1) {
					System.out.print(n + "\t");
					try {
						obj.notifyAll();
						obj.wait();
					} catch (Exception e) {

					}
				}
			}
		});

		Thread t2 = new Thread(() -> {
			synchronized (obj) {
				for (int n : nums2) {
					System.out.print(n + "\t");
					try {
						obj.notifyAll();
						obj.wait();
					} catch (Exception e) {

					}
				}
			}
		});

		t1.start();
		t2.start();
	}


}
