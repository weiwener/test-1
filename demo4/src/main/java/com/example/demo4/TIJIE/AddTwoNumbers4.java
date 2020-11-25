package com.example.demo4.TIJIE;

/**
 * @Description: 2. 两数相加
 * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @Author: wangwei
 * @Date: 2020/11/22 下午10:15
 */
public class AddTwoNumbers4 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (null == l1) {
			return l2;
		}
		if (null == l2) {
			return l1;
		}
		ListNode head = null, t = null;
		int pre = 0;
		while (l1 != null || l2 != null) {
			int val1 = l1 == null ? 0 : l1.val;
			int val2 = l2 == null ? 0 : l2.val;
			int val = (val1 + val2 + pre) % 10;
			if (head == null) {
				t = new ListNode(val);
				head = t;
			} else {
				t.next = new ListNode(val);
				t = t.next;
			}
			pre = (val1 + val2 + pre) / 10;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (pre > 0) {
			t.next = new ListNode(pre);
		}
		return head;
	}
}
