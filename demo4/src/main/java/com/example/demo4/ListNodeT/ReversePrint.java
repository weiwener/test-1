package com.example.demo4.ListNodeT;

import java.util.ArrayList;
import java.util.List;

/** 简单
 * @Description: 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * @Author: wangwei
 * @Date: 2020/11/14 下午3:09
 */
public class ReversePrint {
	public int[] reversePrint(ListNode head) {
		List<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		int length=list.size();
		int[] res = new int[length];
		for (int i = 0; i < length; i++) {
			res[i] = list.get(length-i-1);
		}
		return res;

		//或者用栈
		/*Stack<ListNode> stack = new Stack<ListNode>();
		ListNode temp = head;
		while (temp != null) {
			stack.push(temp);
			temp = temp.next;
		}
		int size = stack.size();
		int[] print = new int[size];
		for (int i = 0; i < size; i++) {
			print[i] = stack.pop().val;
		}
		return print;*/

	}
}
