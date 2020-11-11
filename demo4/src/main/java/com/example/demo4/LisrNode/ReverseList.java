package com.example.demo4.LisrNode;

/** 简单
 * @Description: 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @Author: wangwei
 * @Date: 2020/11/8 下午2:10
 */
public class ReverseList {
	public static ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode next = null;
		while (head != null) {
			next=head.next;
			head.next=pre;
			pre=head;
			head=next;
		}
		return pre;
	}

	public static void main(String[] args) {
		ListNode p1=new ListNode(1);
		ListNode p2=new ListNode(2);
		ListNode p3=new ListNode(3);
		ListNode p4=new ListNode(4);
		ListNode p5=new ListNode(5);
		p1.next=p2;
		p2.next=p3;
		p3.next=p4;
		p4.next=p5;
		p5.next=null;
		reverseList(p1);
	}

}
