package com.example.demo4.ListNodeT;

/** 简单
 * @Description:  删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 * 题目保证链表中节点的值互不相同
 * @Author: wangwei
 * @Date: 2020/11/14 下午3:28
 */
public class DeleteNode {
	public ListNode deleteNode(ListNode head, int val) {
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode end = pre;
		while (head != null) {
			if (head.val == val) {
				end.next = head.next;
				break;
			}
			end = head;
			head = head.next;
		}
		return pre.next;
	}
}
