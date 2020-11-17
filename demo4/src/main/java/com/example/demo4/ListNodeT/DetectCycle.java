package com.example.demo4.ListNodeT;

/** 中等
 * @Description: 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 *
 * 你是否可以使用 O(1) 空间解决此题？
 * @Author: wangwei
 * @Date: 2020/11/15 下午2:01
 */
public class DetectCycle {
	public ListNode detectCycle(ListNode head) {
		/*if (head == null || head.next == null) {
			return null;
		}
		ListNode start = head, end = head;
		int cycleLength = 0;
		while (end != null && end.next != null) {
			start = start.next;
			end = end.next.next;
			cycleLength++;
			if (start == end) {
				break;
			}
		}
		if (end == null || end.next == null) {
			return null;
		}
		end = head;
		start = head;
		while (cycleLength-- > 0) {
			end = end.next;
		}
		while (start != end) {
			start = start.next;
			end = end.next;
		}
		return start;*/

//		优化上面写法,第一次相遇时，快指针2n步，慢指针n步，相差的是环的长度，即慢指针走的步数
		if (head == null || head.next == null) {
			return null;
		}
		ListNode slow = head, fast = head;
		while (fast != null) {
			if (fast.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				ListNode pre = head;
				while (pre != slow) {
					pre = pre.next;
					slow = slow.next;
				}
				return pre;
			}
		}
		return null;
	}
}
