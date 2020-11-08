package com.example.demo4;

/** 中等
 * @Description: 两数相加
 * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
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
 * @Date: 2020/11/8 下午12:17
 */
public class AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null, tail = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int n1 = l1 != null ? l1.val : 0;
			int n2 = l2 != null ? l2.val : 0;
			int sum = n1 + n2 + carry;
			if (head == null) {
				head = tail = new ListNode(sum % 10);
			} else {
				tail.next = new ListNode(sum % 10);
				tail = tail.next;
			}
			carry = sum / 10;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carry > 0) {
			tail.next = new ListNode(carry);
		}
		return head;

//		if (null == l1) {
//			return l2;
//		}
//		if (null == l2) {
//			return l1;
//		}
//		ListNode t = new ListNode(0);
//		ListNode listNode = t;
//		ListNode p1 = l1, p2 = l2;
//		int pre = 0;
//		while (p1 != null || p2 != null) {
//			if(p1!=null&&p2!=null){
//				int val = p1.val + p2.val + pre;
//				if (val > 9) {
//					val = val + pre - 10;
//					pre = 1;
//				} else {
//					pre = 0;
//				}
//				t.val = val;
//				t.next = p1;
//				t = t.next;
//				p1 = p1.next;
//				p2 = p2.next;
//			}else if(p1==null){
//				int val=p2.val+pre;
//				if(val>9){
//					val=val+pre-10;
//					pre=1;
//				}else{
//					pre=0;
//				}
//				t.val=val;
//				t.next=p2;
//				t=t.next;
//				p2=p2.next;
//			}else if(p2==null){
//				int val=p1.val+pre;
//				if(val>9){
//					val=val+pre-10;
//					pre=1;
//				}else{
//					pre=0;
//				}
//				t.val=val;
//				t.next=p1;
//				t=t.next;
//				p1=p1.next;
//			}
//		}
//		t=null;
//		return listNode;
	}

	public static void main(String[] args) {
		ListNode p1=new ListNode(2);
		ListNode p2=new ListNode(4);
		ListNode p3=new ListNode(3);
		p1.next=p2;
		p2.next=p3;
		ListNode q1=new ListNode(5);
		ListNode q2=new ListNode(6);
		ListNode q3=new ListNode(4);
		q1.next=q2;
		q2.next=q3;
		ListNode re=addTwoNumbers(p1,q1);
	}
}
