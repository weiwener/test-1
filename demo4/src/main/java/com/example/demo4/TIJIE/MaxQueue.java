package com.example.demo4.TIJIE;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author: wangwei
 * @Date: 2021/1/10 下午5:35
 */
public class MaxQueue {
	Queue<Integer> q;
	Deque<Integer> d;

	public MaxQueue() {
		q = new LinkedList<Integer>();
		d = new LinkedList<Integer>();
	}

	public int max_value() {
		if (d.isEmpty()) {
			return -1;
		}
		return d.peekFirst();
	}

	//由数学归纳法可知队列将会始终保持单调递减。
	public void push_back(int value) {
		while (!d.isEmpty() && d.peekLast() < value) {
			d.pollLast();
		}
		d.offerLast(value);
		q.offer(value);
	}

	public int pop_front() {
		if (q.isEmpty()) {
			return -1;
		}
		int ans = q.poll();
		if (ans == d.peekFirst()) {
			d.pollFirst();
		}
		return ans;
	}
}
