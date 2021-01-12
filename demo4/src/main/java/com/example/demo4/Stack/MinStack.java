package com.example.demo4.Stack;

import java.util.Stack;

/** 简单
 * @Description:155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * @Author: wangwei
 * @Date: 2020/11/20 下午11:25
 */
public class MinStack {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	/** initialize your data structure here. */
	public MinStack() {
		stack1=new Stack<>();
		stack2=new Stack<>();
	}

	public void push(int x) {
		stack1.push(x);
		if(stack2.isEmpty()||stack2.peek()>=x){
			stack2.push(x);
		}
	}

	public void pop() {
		if(stack1.pop().equals(stack2.peek())){
			stack2.pop();
		}
	}

	public int top() {
		return stack1.peek();
	}

	public int getMin() {
		return stack2.peek();

	}

	public static void main(String[] args) {
		MinStack stack1=new MinStack();
		stack1.push(512);
		stack1.push(-1024);
		stack1.push(-1024);
		stack1.push(512);
		stack1.pop();
		int a=stack1.getMin();
		stack1.pop();;
		int b=stack1.getMin();
		stack1.pop();;
		int c=stack1.getMin();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

	}
}
