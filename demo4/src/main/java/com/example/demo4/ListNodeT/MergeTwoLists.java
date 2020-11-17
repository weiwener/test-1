package com.example.demo4.ListNodeT;

/** 简单
 * @Description: 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @Author: wangwei
 * @Date: 2020/11/9 下午1:11
 */
public class MergeTwoLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		/*//递归方法
		if(l1==null){
			return l2;
		}
		if(l2==null){
			return l1;
		}
		if(l1.val<=l2.val){
			l1.next=mergeTwoLists(l1.next,l2);
			return l1;
		}else{
			l2.next=mergeTwoLists(l1,l2.next);
			return l2;
		}*/
//		ListNode pre = new ListNode(0);
//		ListNode flag = pre;
        //等价
		ListNode flag = new ListNode(0);
		ListNode pre=flag;
		while(l1!=null&&l2!=null){
			if(l1.val<=l2.val){
				flag.next=l1;
				l1=l1.next;
			}else{
				flag.next=l2;
				l2=l2.next;
			}
			flag=flag.next;
		}
		flag.next=l1==null?l2:l1;
		return pre.next;
	}

	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(4);
		l1.next=l2;
		l2.next=l3;
		ListNode l4=new ListNode(1);
		ListNode l5=new ListNode(3);
		ListNode l6=new ListNode(4);
		l4.next=l5;
		l5.next=l6;
		ListNode p1=l1;
		p1.next=new ListNode(0);
		System.out.println(p1);
		System.out.println(l1);

		ListNode p2=l4;
		l4.next=new ListNode(0);
		System.out.println(p2);
		System.out.println(l4);
		ListNode p=mergeTwoLists(l1,l4);
		System.out.println(p);
	}
}
