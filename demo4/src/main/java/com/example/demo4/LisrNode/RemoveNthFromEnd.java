package com.example.demo4.LisrNode;

import com.example.demo4.LisrNode.ListNode;

/** 中等
 * @Description: 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * @Author: wangwei
 * @Date: 2020/11/8 下午11:00
 */
public class RemoveNthFromEnd {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
//		ListNode p1 = head;
//		while (p1 != null && n > 0) {
//			p1 = p1.next;
//			n--;
//		}
//		ListNode p2 = head;
//		ListNode pre = null;
//		while (p1 != null) {
//			p1 = p1.next;
//			pre = p2;
//			p2 = p2.next;
//		}
//		p2=p2.next;
//		if(pre==null){
//			return p2==null?pre:p2;
//		}else{
//			pre.next = p2;
//		}
//		return head;

		//leet答案容易出现空指针 ，可以加上下面两行
		if (head == null) {
			return null;
		}
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode start = pre, end = pre;
		while(n != 0) {
			start = start.next;
			n--;
		}
		while(start.next != null) {
			start = start.next;
			end = end.next;
		}
		end.next = end.next.next;
		return pre.next;
	}

	public static void main(String[] args) {
		ListNode p1=new ListNode(1);
		ListNode p2=new ListNode(2);
		ListNode p3=new ListNode(3);
		ListNode p4=new ListNode(4);
		ListNode p5=new ListNode(5);
//		p1.next=p2;
//		p2.next=p3;
//		p3.next=p4;
//		p4.next=p5;
		ListNode listNode=removeNthFromEnd(p1,1);
		ListNode p=removeNthFromEnd(null,0);
	}
}
