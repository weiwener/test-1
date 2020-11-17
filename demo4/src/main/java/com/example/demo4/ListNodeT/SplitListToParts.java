package com.example.demo4.ListNodeT;

/** 中等
 * @Description: 分隔链表
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 *
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 *
 * 返回一个符合上述规则的链表的列表。
 *
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 *
 * 示例 1：
 *
 * 输入:
 * root = [1, 2, 3], k = 5
 * 输出: [[1],[2],[3],[],[]]
 * 解释:
 * 输入输出各部分都应该是链表，而不是数组。
 * 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
 * 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 * 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。

 * 示例 2：
 *
 * 输入:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度
 * @Author: wangwei
 * @Date: 2020/11/16 下午7:09
 */
public class SplitListToParts {
	public static ListNode[] splitListToParts(ListNode root, int k) {
		ListNode[] listNodes = new ListNode[k];
		int length = 0;
		ListNode head = root;
		while (head != null) {
			length++;
			head = head.next;
		}
		int perCount = length / k;
		int remain = length % k;

		ListNode cur = root;
		for (int i = 0; i < k; i++) {
			ListNode pre = new ListNode(0), tmp = pre;
			for (int j = 0; j < perCount + (i < remain ? 1 : 0); j++) {
				if (cur == null) {
					break;
				}
				tmp.next = cur;
				tmp = cur;
				cur = cur.next;
			}
			tmp.next = null;
			listNodes[i] = pre.next;
		}
		return listNodes;
	}

	public static void main(String[] args) {
		ListNode p1=new ListNode(1);
		ListNode p2=new ListNode(2);
		ListNode p3=new ListNode(3);
		ListNode p4=new ListNode(4);
		ListNode p5=new ListNode(5);
		ListNode p6=new ListNode(6);
		ListNode p7=new ListNode(7);
		p1.next=p2;
		p2.next=p3;
		p3.next=p4;
//		p4.next=p5;
//		p5.next=p6;
//		p6.next=p7;
		ListNode[] parts=splitListToParts(null,3);
	}
}
