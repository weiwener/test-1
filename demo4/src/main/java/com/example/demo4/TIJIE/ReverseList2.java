package com.example.demo4.TIJIE;

/**
 * @Description: 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @Author: wangwei
 * @Date: 2020/11/22 下午10:12
 */
public class ReverseList2 {
	public ListNode reverseList(ListNode head) {
		ListNode pre=null,next=null;
		while(head!=null){
			next=head.next;
			head.next=pre;
			pre=head;
			head=next;
		}
		return pre;
	}
}
