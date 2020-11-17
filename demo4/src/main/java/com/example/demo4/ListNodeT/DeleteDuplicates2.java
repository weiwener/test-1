package com.example.demo4.ListNodeT;

/** 中等
 * @Description: 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * @Author: wangwei
 * @Date: 2020/11/14 下午10:45
 */
public class DeleteDuplicates2 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode start = pre, end = head.next;
		Boolean flag = false;
		while (end != null) {
			if (head.val == end.val) {
				flag = true;
				head = head.next;
				end = end.next;
			} else {
				if (flag) {
					head = head.next;
					end = end.next;
					start.next = head;
					flag = false;
				} else {
					start = start.next;
					head = head.next;
					end = end.next;
				}
			}
		}
		if(flag){
			start.next=end;
		}
		return pre.next;

		/*//递归
		if (head == null || head.next == null) {
			return head;
		}
		if (head.val == head.next.val) {
			while (head != null && head.next != null && head.val == head.next.val) {
				head = head.next;
			}
			return deleteDuplicates(head.next);
		} else {
			head.next = deleteDuplicates(head.next);
			return head;
		}*/


		/*if(head==null || head.next==null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode a = dummy;
		ListNode b = head;
		while(b!=null && b.next!=null) {
			//初始化的时a指向的是哑结点，所以比较逻辑应该是a的下一个节点和b的下一个节点
			if(a.next.val!=b.next.val) {
				a = a.next;
				b = b.next;
			}
			else {
				//如果a、b指向的节点值相等，就不断移动b，直到a、b指向的值不相等
				while(b!=null && b.next!=null && a.next.val==b.next.val) {
					b = b.next;
				}
				a.next = b.next;
				b = b.next;
			}
		}
		return dummy.next;
*/
	}
}
