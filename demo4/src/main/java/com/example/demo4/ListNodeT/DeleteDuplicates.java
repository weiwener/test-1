package com.example.demo4.ListNodeT;

/** 简单
 * @Description: 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * @Author: wangwei
 * @Date: 2020/11/14 下午10:15
 */
public class DeleteDuplicates {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return head;
	}
}
