package com.example.demo4;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description:
 * @Author: wangwei
 * @Date: 2020/7/5 上午11:35
 */
public class SolutionStack {
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		if(pushed==null||popped==null||pushed.length!=popped.length){
			return false;
		}
		Stack<Integer> stack1=new Stack<>();
		Stack<Integer> stack2=new Stack<>();
		for(int i=pushed.length-1;i>=0;i--){
			stack1.push(pushed[i]);
		}

		int i = 0;
		while (!stack1.isEmpty()) {
			if (popped[i] != stack1.peek()) {
				if(!stack2.isEmpty()&&stack2.peek()==popped[i]){
					stack2.pop();
					i++;
				}else{
					stack2.push(stack1.pop());
				}
			} else {
				stack1.pop();
				i++;
			}
		}


		while (i < popped.length) {
			if (!stack2.isEmpty()) {
				if (stack2.pop() == popped[i]) {
					i++;
				} else {
					break;
				}
			} else {
				break;
			}

		}


		if (stack2.isEmpty() && i == popped.length) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int []pushed = new int[]{2,1,0};
		int []popped = new int[]{1,2,0};
		int []right=Arrays.copyOfRange(pushed,2,2);
		Boolean flag=validateStackSequences(pushed,popped);
		System.out.println(flag);
	}
}
