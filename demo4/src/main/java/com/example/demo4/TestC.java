package com.example.demo4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 模拟OutOfMemoryError
 * @Author: wangwei
 * @Date: 2019/12/18 下午8:40
 */
public class TestC {
	public static void main(String[] args) {
//		ListNode a=new ListNode(4);
//		ListNode b=new ListNode(5);
//		ListNode c=new ListNode(1);
//		ListNode d=new ListNode(9);
//
//		a.next=b;
//		b.next=c;
//		c.next=d;
//		deleteNode2(b);
		int[] nums=new int[]{1,2,3,4,5};
		isStraight(nums);


	}

	public static int countCharacters(String[] words, String chars) {
		int length=0;
		for(int i=0;i<words.length;i++){
			String copy=chars;
			for(int j=0;j<words[i].length();j++){
				if(!copy.contains(String.valueOf(words[i].charAt(j)))){
					break;
				}else{
					copy=copy.replaceFirst(String.valueOf(words[i].charAt(j)),"");
				}
			}
			if(words[i].length()==(chars.length()-copy.length())){
				length+=words[i].length();
			}
		}
		return length;
	}

	public static int longestPalindrome(String s) {
		int[] arr=new int[57];
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);

			arr[c-'a']+=1;
		}
		int maxLenth=0;
		boolean flag=false;
		for(int j=0;j<arr.length;j++){
			if(arr[j]/2==0){
				maxLenth+=arr[j];
			}else if(arr[j]>1&&arr[j]/2==1){
				maxLenth+=(arr[j]-1);
			}else if(arr[j]==1){
				flag=true;
			}
		}
		if(flag){
			maxLenth+=1;
		}

		Map<String,Integer> map =new HashMap<>();
		map.size();

		return maxLenth;
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null&&l2==null){
			return null;
		}
		if(l1!=null&&l2==null){
			return l1;
		}
		if(l1==null&&l2!=null){
			return l2;
		}
		ListNode p=l1;
		ListNode q=l2;
		ListNode m=new ListNode(0);
		if(l1.val>l2.val){
			m.next=l2;
			q=q.next;
		}else{
			m.next=l1;
			p=p.next;
		}
		ListNode temp=m.next;
		while(p!=null&&q!=null){
			if(p.val<q.val){
				temp.next=p;
				temp=p;
				p=p.next;
			}else{
				temp.next=q;
				temp=q;
				q=q.next;
			}
		}
		if(p==null&&q!=null){
			temp.next=q;
		}
		if(p!=null&&q==null){
			temp.next=p;
		}
		return m.next;
	}

	//237. 删除链表中的节点
	public static void deleteNode1(ListNode node) {
		node.val=node.next.val;
		node.next=node.next.next;
	}
	public static void deleteNode2(ListNode node) {
		node=node.next;
	}

	public static boolean isStraight(int[] nums) {
		int[] array=new int[14];
		for(int i=0;i<nums.length;i++){
			if(array[nums[i]]!=0){
				if(nums[i]==0){
					array[0]+=1;
				}else{
					return false;
				}
			}else{
				array[nums[i]]=1;
			}
		}

		int num=array[0];
		int left=1,rigth=13;
		while(array[left]!=0&&array[rigth]!=0&&left<rigth){
			if(array[left]==0){
				left++;
			}
			if(array[rigth]==0){
				rigth--;
			}
		}
		if(num==0){
			if(rigth-left==4){
				return true;
			}
		}else{
			if(rigth-left<=4){
				return true;
			}
		}
		return false;
	}
}
