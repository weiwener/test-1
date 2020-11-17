package com.example.demo4.ListNodeT;

/** 简单
 * @Description: 两个链表的第一个公共节点
 * @Author: wangwei
 * @Date: 2020/11/13 下午3:21
 */
public class GetIntersectionNode {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode preA = headA, preB = headB;
		int countA = 0, countB = 0;
		while (preA.next != null) {
			countA++;
			preA = preA.next;
		}
		while (preB.next != null) {
			countB++;
			preB = preB.next;
		}
		int diff = countA - countB;
		preA = headA;
		preB = headB;
		if (diff > 0) {
			while (diff > 0) {
				preA = preA.next;
				diff--;
			}
		} else {
			while (diff < 0) {
				preB = preB.next;
				diff++;
			}
		}
		//走到最后，最终会有两种可能，一种是headA为空，
		//也就是说他们俩不相交。还有一种可能就是headA
		//不为空，也就是说headA就是他们的交点
		while (preA != preB) {
			preA = preA.next;
			preB = preB.next;
		}
		return preA;

		/*//另一种思路，A走到自己的尾结点再指向B的头结点继续走，B走到自己的尾结点再执行A的头结点继续走
		//tempA和tempB我们可以认为是A,B两个指针
		ListNode tempA = headA;
		ListNode tempB = headB;
		while (tempA != tempB) {
			//如果指针tempA不为空，tempA就往后移一步。
			//如果指针tempA为空，就让指针tempA指向headB（注意这里是headB不是tempB）
			tempA = tempA == null ? headB : tempA.next;
			//指针tempB同上
			tempB = tempB == null ? headA : tempB.next;
		}
		//tempA要么是空，要么是两链表的交点
		return tempA;*/

	}
}
