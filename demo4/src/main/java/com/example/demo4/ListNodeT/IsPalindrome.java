package com.example.demo4.ListNodeT;

/** 简单
 * @Description:  回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * @Author: wangwei
 * @Date: 2020/11/16 下午10:59
 */
public class IsPalindrome {
	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		//反转链表
		ListNode secondHalfStart = reverse(slow.next);
		//// 判断是否回文
		ListNode p1 = head, p2 = secondHalfStart;
		Boolean result = true;
		while (result && p2 != null) {
			if (p1.val != p2.val) {
				result = false;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		//还原链表
		slow.next = reverse(secondHalfStart);
		return result;

	}

	public ListNode reverse(ListNode root) {
		if (root == null) {
			return root;
		}
		ListNode pre = null, cur = null;
		while (root != null) {
			cur = root.next;
			root.next = pre;
			pre = root;
			root = cur;
		}
		return pre;
	}
}
