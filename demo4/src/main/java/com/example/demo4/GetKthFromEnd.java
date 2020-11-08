package com.example.demo4;

/** 简单
 * @Description: 链表中倒数第k个节点
 *输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 *  
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 * @Author: wangwei
 * @Date: 2020/11/8 下午7:37
 */
public class GetKthFromEnd {
	public static ListNode getKthFromEnd(ListNode head, int k) {
		ListNode p1 = head;
		while (p1 != null && k > 0) {
			p1 = p1.next;
			k--;
		}
		ListNode p2 = head;
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}

	public static void main(String[] args) {
		ListNode listNode=new ListNode(1);
		ListNode p=getKthFromEnd(listNode,1);
	}
}
