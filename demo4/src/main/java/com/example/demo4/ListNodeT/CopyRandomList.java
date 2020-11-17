package com.example.demo4.ListNodeT;

import java.util.HashMap;
import java.util.Map;

/** 中等
 * @Description: 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * @Author: wangwei
 * @Date: 2020/11/15 下午8:59
 */
public class CopyRandomList {
	public Node copyRandomList(Node head) {
		if (head == null) {
			return head;
		}
		Node pre = null, cur = head;
		//1.复制各节点，并构建拼接链表
		while (cur != null) {
			pre = new Node(cur.val);
			pre.next = cur.next;
			cur.next = pre;
			cur = cur.next.next;
		}
		//2.构建各新节点的 random 指向
		cur = head;
		while (cur != null) {
			cur.next.random = cur.random != null ? cur.random.next : null;
			cur = cur.next.next;
		}
		//3.拆分两链表
		cur = head;
		pre = head.next;
		Node newNode = pre;
		while (newNode.next != null) {
			cur.next = cur.next.next;
			newNode.next = newNode.next.next;
			cur = cur.next;
			newNode = newNode.next;
		}
		// 单独处理原链表尾节点
		cur.next = null;
		return pre;

		//哈希表解法，不过空间复杂度是O(n)
		/*if(head == null) return null;
		Node cur = head;
		Map<Node, Node> map = new HashMap<>();
		// 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
		while(cur != null) {
			map.put(cur, new Node(cur.val));
			cur = cur.next;
		}
		cur = head;
		// 4. 构建新链表的 next 和 random 指向
		while(cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}
		// 5. 返回新链表的头节点
		return map.get(head);*/


	}
}
