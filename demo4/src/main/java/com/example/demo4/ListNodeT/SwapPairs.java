package com.example.demo4.ListNodeT;

/** 中等
 * @Description:  两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 * @Author: wangwei
 * @Date: 2020/11/16 下午5:05
 */
public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode cur = head, pre = cur.next;
		int tmp = 0;
		while (cur != null && pre != null) {
			tmp = pre.val;
			pre.val = cur.val;
			cur.val = tmp;
			cur = pre.next;
			pre = cur == null ? null : cur.next;
		}
		return head;
	}
}
