package com.example.demo4.TIJIE;

import java.util.*;

/**
 * @Description:
 * @Author: wangwei
 * @Date: 2020/11/22 下午10:21
 */
public class Solution {
	public static void main(String[] args) {
		int[] nums1 = {10,9,2,5,3,7,101,18};
		//lengthOfLIS(nums1);

		int[][] nums2={{0,1,0},{1,0,0},{1,0,0}};
		uniquePathsWithObstacles(nums2);

		generateParenthesis(3);

		/*Object obj = new Object();

		Thread t1 = new Thread(() -> {
			synchronized (obj) {
				for (int n : nums1) {
					System.out.print(n + "\t");
					try {
						obj.notifyAll();
						obj.wait();
					} catch (Exception e) {

					}
				}
			}
		});

		Thread t2 = new Thread(() -> {
			synchronized (obj) {
				for (int n : nums2) {
					System.out.print(n + "\t");
					try {
						obj.notifyAll();
						obj.wait();
					} catch (Exception e) {

					}
				}
			}
		});

		t1.start();
		t2.start();*/
	}

	/*1. 两数之和
	给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
	你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
	示例:
	给定 nums = [2, 7, 11, 15], target = 9

	因为 nums[0] + nums[1] = 2 + 7 = 9
	所以返回 [0, 1]*/
	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++){
			if(map.get(target-nums[i])!=null){
				return new int[]{map.get(target-nums[i]),i};
			}
			map.put(nums[i], i);
		}
		return new int[]{0};
	}

	/*206. 反转链表
	反转一个单链表。
	示例:
	输入: 1->2->3->4->5->NULL
	输出: 5->4->3->2->1->NULL*/
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

	/*
	 * 2. 两数相加
	 * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
	 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
	 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
	 * 示例：
	 *
	 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * 输出：7 -> 0 -> 8
	 * 原因：342 + 465 = 807
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (null == l1) {
			return l2;
		}
		if (null == l2) {
			return l1;
		}
		ListNode head = null, t = null;
		int pre = 0;
		while (l1 != null || l2 != null) {
			int val1 = l1 == null ? 0 : l1.val;
			int val2 = l2 == null ? 0 : l2.val;
			int val = (val1 + val2 + pre) % 10;
			if (head == null) {
				t = new ListNode(val);
				head = t;
			} else {
				t.next = new ListNode(val);
				t = t.next;
			}
			pre = (val1 + val2 + pre) / 10;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (pre > 0) {
			t.next = new ListNode(pre);
		}
		return head;
	}

	/*
	 * @Description: 无重复字符的最长子串
	 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
	 * 示例1:
	 * 输入: "abcabcbb"
	 * 输出: 3
	 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
	 * 示例 2:
	 * 输入: "bbbbb"
	 * 输出: 1
	 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
	 * 示例 3:
	 * 输入: "pwwkew"
	 * 输出: 3
	 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
	 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
	 */
	public int lengthOfLongestSubstring(String s) {
		Map<Character,Integer> map=new HashMap<>();
		int start=0,result=0;
		for(int end=0;end<s.length();end++){
			char a=s.charAt(end);
			if(map.containsKey(a)){
				start=Math.max(map.get(a),start);
			}
			result=Math.max(end-start+1,result);
			map.put(a,end+1);
		}
		return result;
	}

	/*
	 * @Description: 20. 有效的括号
	 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
	 * 有效字符串需满足：
	 * 左括号必须用相同类型的右括号闭合。
	 * 左括号必须以正确的顺序闭合。
	 * 注意空字符串可被认为是有效字符串。
	 * 示例 1:
	 * 输入: "()"
	 * 输出: true
	 * 示例2：
	 * 输入: "()[]{}"
	 * 输出: true
	 * 示例3:
	 *
	 * 输入: "(]"
	 * 输出: false
	 */
	public boolean isValid(String s) {
		int length=s.length();
		if (length % 2 == 1) {
			return false;
		}
		Map<Character,Character> map=new HashMap<Character, Character>(){{
			put(')','(');
			put('}','{');
			put(']','[');
		}};
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<length;i++){
			if(map.containsKey(s.charAt(i))){
				if(stack.isEmpty()||!stack.peek().equals(map.get(s.charAt(i)))){
					return false;
				}
				stack.pop();
			}else{
				stack.push(s.charAt(i));
			}
		}
		return stack.isEmpty();
	}

	/*
	 * @Description: 7. 整数反转
	 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
	 * 示例1:
	 * 输入: 123
	 * 输出: 321
	 * 示例 2:
	 * 输入: -123
	 * 输出: -321
	 * 示例 3:
	 * 输入: 120
	 * 输出: 21
	 */
	public int reverse(int x) {
		int res=0;
		while(x!=0){
			int pop=x%10;
			x=x/10;
			if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&pop>7)){
				return 0;
			}
			if(res<Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE/10&&pop<-8)){
				return 0;
			}
			res=res*10+pop;
		}
		return res;
	}

	/*
	 * @Description: 9. 回文数
	 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
	 * 示例 1:
	 * 输入: 121
	 * 输出: true
	 * 示例2:
	 * 输入: -121
	 * 输出: false
	 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
	 * 示例 3:
	 * 输入: 10
	 * 输出: false
	 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
	 */
	//把后半部分反转，然后与前半部分比较
	public boolean isPalindrome(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		int revers = 0;
		while (x > revers) {
			revers = revers * 10 + x % 10;
			x = x / 10;
		}
		return x == revers || x == revers / 10;
	}

	/*26. 删除排序数组中的重复项
	给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
	不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
	示例1:
	给定数组 nums = [1,1,2],
	函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。*/
	public int removeDuplicates(int[] nums) {
		if(nums==null||nums.length==0){
			return 0;
		}
		int i=0;
		for(int j=1;j<nums.length;j++){
			if(nums[i]!=nums[j]){
				nums[++i]=nums[j];
			}
		}
		return i+1;
	}

    /*14. 最长公共前缀
	编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串""。
    示例1:
	输入: ["flower","flow","flight"]
	输出: "fl"
	示例2:
	输入: ["dog","racecar","car"]
	输出: ""
	解释: 输入不存在公共前缀。*/
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String result = strs[0];
		for (int i = 1; i < strs.length; i++) {
			result = longPub(result, strs[i]);
			if (result.length() == 0) {
				return result;
			}
		}
		return result;
	}

	public String longPub(String str1, String str2) {
		int minLength = Math.min(str1.length(), str2.length());
		int index = 0;
		while (index < minLength && str1.charAt(index) == str2.charAt(index)) {
			index++;
		}
		return str1.substring(0, index);
	}

	/*13. 罗马数字转整数
	罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

	字符          数值
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
	例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
	通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
	同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
	I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
	X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
	C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
	给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
	示例 1:
    输入: "III"
	输出: 3
	示例 2:
	输入: "IV"
	输出: 4
	示例 3:
	输入: "IX"
	输出: 9
	示例 4:

	输入: "LVIII"
	输出: 58
	解释: L = 50, V= 5, III = 3.
	示例 5:

	输入: "MCMXCIV"
	输出: 1994
	解释: M = 1000, CM = 900, XC = 90, IV = 4.*/
	public int romanToInt(String s) {
		int sum = 0;
		int preNum = getValue(s.charAt(0));
		for(int i = 1;i < s.length(); i ++) {
			int num = getValue(s.charAt(i));
			if(preNum < num) {
				sum -= preNum;
			} else {
				sum += preNum;
			}
			preNum = num;
		}
		sum += preNum;
		return sum;
	}

	private int getValue(char ch) {
		switch(ch) {
			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
			default: return 0;
		}
	}

	/*面试题 10.01. 合并排序的数组
	给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
	初始化 A 和 B 的元素数量分别为 m 和 n。
	示例:
	输入:
	A = [1,2,3,0,0,0], m = 3
	B = [2,5,6],       n = 3

	输出: [1,2,2,3,5,6]*/
	public void merge(int[] A, int m, int[] B, int n) {
		//逆向双指针
		int pa = m - 1, pb = n - 1;
		int tail = m + n - 1;
		int cur;
		while (pa >= 0 || pb >= 0) {
			if (pa == -1) {
				cur = B[pb--];
			} else if (pb == -1) {
				cur = A[pa--];
			} else if (A[pa] > B[pb]) {
				cur = A[pa--];
			} else {
				cur = B[pb--];
			}
			A[tail--] = cur;
		}
	}

	/*19. 删除链表的倒数第N个节点
	给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
	示例：
	给定一个链表: 1->2->3->4->5, 和 n = 2.
	当删除了倒数第二个节点后，链表变为 1->2->3->5.*/
	public ListNode removeNthFromEnd(ListNode head, int n) {
		/*ListNode p1 = head;
		while (p1 != null && n > 0) {
			p1 = p1.next;
			n--;
		}
		ListNode p2 = head;
		ListNode pre = null;
		while (p1 != null) {
			p1 = p1.next;
			pre = p2;
			p2 = p2.next;
		}
		p2=p2.next;
		if(pre==null){
			return p2==null?pre:p2;
		}else{
			pre.next = p2;
		}
		return head;*/
		if (head == null) {
			return null;
		}

		ListNode dummy = new ListNode(0);
		dummy.next=head;
		ListNode first = head;
		ListNode second = dummy;
		for (int i = 0; i < n; ++i) {
			first = first.next;
		}
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;
	}

	/*27. 移除元素
	给你一个数组 nums 和一个值 val，你需要原地移除所有数值等于val的元素，并返回移除后数组的新长度。
	不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
	元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
示例 1:
    给定nums = [3,2,2,3], val = 3,
    函数应该返回新的长度2, 并且 nums 中的前两个元素均为 2。
	你不需要考虑数组中超出新长度后面的元素。
	示例 2:
	给定 nums = [0,1,2,2,3,0,4,2], val = 2,
	函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
	注意这五个元素可为任意顺序。
	你不需要考虑数组中超出新长度后面的元素。*/
	public int removeElement(int[] nums, int val) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i++] = nums[j];
			}
		}
		return i;
	}

/*
35. 搜索插入位置
	给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
	你可以假设数组中无重复元素。
	示例 1:
	输入: [1,3,5,6], 5
	输出: 2
	示例 2:
	输入: [1,3,5,6], 2
	输出: 1
	示例 3:
	输入: [1,3,5,6], 7
	输出: 4
	示例 4:
	输入: [1,3,5,6], 0
	输出: 0
*/
	public int searchInsert(int[] nums, int target) {
		//二分查找
		int left = 0, right = nums.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(nums[mid] == target) {
				return mid;
			} else if(nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	/*5. 最长回文子串
	给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
	示例 1：
	输入: "babad"
	输出: "bab"
	注意: "aba" 也是一个有效答案。
	示例 2：
	输入: "cbbd"
	输出: "bb"*/
	//动态规划
	public String longestPalindrome1(String s) {
		if (s==null||s.length() < 2)
			return s;
		int length=s.length();
		int start=0,end=0,maxlength=1;
		boolean[][] dp=new boolean[length][length];
		for(int i=1;i<length;i++){
			for(int j=0;j<i;j++){
				if(s.charAt(i)==s.charAt(j)&&(i-j<=2||dp[j+1][i-1])) {
					dp[j][i] = true;
					if(maxlength<i-j+1){
						maxlength=i-j+1;
						start=j;
						end=i;
					}
				}
			}
		}
		return s.substring(start,end+1);
	}

	/*121. 买卖股票的最佳时机
	给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
	如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
	注意：你不能在买入股票前卖出股票。
	示例 1:
	输入: [7,1,5,3,6,4]
	输出: 5
	解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
	注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
	示例 2:
	输入: [7,6,4,3,1]
	输出: 0
	解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。*/
	public int maxProfit(int[] prices) {
		int minprice = Integer.MAX_VALUE;
		int maxprofit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minprice) {
				minprice = prices[i];
			} else if (prices[i] - minprice > maxprofit) {
				maxprofit = prices[i] - minprice;
			}
		}
		return maxprofit;
	}

	/*70. 爬楼梯
	假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
	每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
	注意：给定 n 是一个正整数。

	示例 1：
	输入： 2
	输出： 2
	解释： 有两种方法可以爬到楼顶。
			1.  1 阶 + 1 阶
2.  2 阶*/
	public int climbStairs(int n) {
		int a=1,b=2;
		if(n==1){
			return a;
		}
		if(n==2){
			return b;
		}
		int result=0;
		for(int i=3;i<=n;i++){
			result=a+b;
			a=b;
			b=result;
		}
		return b;
	}

	/*4. 寻找两个正序数组的中位数
	给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
	进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
    示例 1：
	输入：nums1 = [1,3], nums2 = [2]
	输出：2.00000
	解释：合并数组 = [1,2,3] ，中位数 2
	示例 2：
	输入：nums1 = [1,2], nums2 = [3,4]
	输出：2.50000
	解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
	示例 3：
	输入：nums1 = [0,0], nums2 = [0,0]
	输出：0.00000
	示例 4：
	输入：nums1 = [], nums2 = [1]
	输出：1.00000
	示例 5：
	输入：nums1 = [2], nums2 = []
	输出：2.00000*/
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums;
		int m = nums1.length;
		int n = nums2.length;
		nums = new int[m + n];
		if (m == 0) {
			if (n % 2 == 0) {
				return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
			} else {

				return nums2[n / 2];
			}
		}
		if (n == 0) {
			if (m % 2 == 0) {
				return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
			} else {
				return nums1[m / 2];
			}
		}

		int count = 0;
		int i = 0, j = 0;
		while (count != (m + n)) {
			if (i == m) {
				while (j != n) {
					nums[count++] = nums2[j++];
				}
				break;
			}
			if (j == n) {
				while (i != m) {
					nums[count++] = nums1[i++];
				}
				break;
			}

			if (nums1[i] < nums2[j]) {
				nums[count++] = nums1[i++];
			} else {
				nums[count++] = nums2[j++];
			}
		}

		if (count % 2 == 0) {
			return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
		} else {
			return nums[count / 2];
		}
	}


	/*53. 最大子序和
	给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
	示例:
	输入: [-2,1,-3,4,-1,2,1,-5,4]
	输出: 6
	解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。*/
	public int maxSubArray(int[] nums) {
		int pre = 0, maxAns = nums[0];
		for (int x : nums) {
			pre = Math.max(pre + x, x);
			maxAns = Math.max(maxAns, pre);
		}
		return maxAns;
	}

	/*21. 合并两个有序链表
	将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    示例：
	输入：1->2->4, 1->3->4
	输出：1->1->2->3->4->4*/
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode pre=new ListNode(0);
		ListNode cur=pre;
		while(l1!=null&&l2!=null){
			if(l1.val<l2.val){
				cur.next=l1;
				l1=l1.next;
			}else{
				cur.next=l2;
				l2=l2.next;
			}
			cur=cur.next;
		}
		cur.next=l1==null?l2:l1;
		return pre.next;
	}

	/*283. 移动零
	给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
	示例:
	输入: [0,1,0,3,12]
	输出: [1,3,12,0,0]
	说明:
	必须在原数组上操作，不能拷贝额外的数组。
	尽量减少操作次数。*/
	public void moveZeroes(int[] nums) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != 0) {
				nums[i] = nums[j];
				if(i!=j){
					nums[j] = 0;
				}
				i++;
			}
		}
	}

	/*66. 加一
	给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
	最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
	你可以假设除了整数 0 之外，这个整数不会以零开头。
    示例 1：
	输入：digits = [1,2,3]
	输出：[1,2,4]
	解释：输入数组表示数字 123。
	示例 2：
	输入：digits = [4,3,2,1]
	输出：[4,3,2,2]
	解释：输入数组表示数字 4321。
	示例 3：
	输入：digits = [0]
	输出：[1]*/
	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i]++;
			digits[i] = digits[i] % 10;
			if (digits[i] != 0) {
				return digits;
			}
		}
		digits = new int[]{digits.length + 1};
		digits[0] = 1;
		return digits;
	}

	/*8. 字符串转换整数 (atoi)
	请你来实现一个 atoi 函数，使其能将字符串转换成整数。
	首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
	如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
	假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
	该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
	注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
	在任何情况下，若函数不能进行有效的转换时，请返回 0 。
	提示：
    本题中的空白字符只包括空格字符 ' ' 。
	假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
示例 1:
	输入: "42"
	输出: 42
	示例 2:

	输入: "   -42"
	输出: -42
	解释: 第一个非空白字符为 '-', 它是一个负号。
	我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
	示例 3:

	输入: "4193 with words"
	输出: 4193
	解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
	示例 4:

	输入: "words and 987"
	输出: 0
	解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
	因此无法执行有效的转换。
	示例 5:

	输入: "-91283472332"
	输出: -2147483648
	解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
	因此返回 INT_MIN (−231) 。*/
	public int myAtoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		int flag = 1, i = 0, result = 0;
		int length = str.length(), maxBiary = Integer.MAX_VALUE / 10;
		//判断空格
		while (str.charAt(i) == ' ') {
			if (++i == length) {
				return 0;
			}
		}
		//判断正负位
		if (str.charAt(i) == '-') {
			flag = -1;
			i++;
		} else if (str.charAt(i) == '+') {
			i++;
		}
		//计算绝对值大小
		for (int j = i; j < length; j++) {
			if (str.charAt(j) < '0' || str.charAt(j) > '9') {
				return result*flag;
			}
			if (result > maxBiary || (result == maxBiary && str.charAt(j) > '7')) {
				return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result * 10 + (str.charAt(j)-'0');
		}
		return result * flag;
	}

	/*28. 实现 strStr()
	实现 strStr() 函数。
	给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
	示例 1:

	输入: haystack = "hello", needle = "ll"
	输出: 2
	示例 2:

	输入: haystack = "aaaaa", needle = "bba"
	输出: -1*/
	public int strStr(String haystack, String needle) {
		int L = needle.length(), n = haystack.length();
		if (L == 0) {
			return 0;
		}
		int pn = 0;
		while (pn < n - L + 1) {
			while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) {
				++pn;
			}
			int pL = 0;
			while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
				++pn;
				++pL;
			}
			if (pL == L) {
				return pn - L;
			}
			pn = pn - pL + 1;
		}
		return -1;
	}

	/*11. 盛最多水的容器
	给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
	找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器。
示例 1：
输入：[1,8,6,2,5,4,8,3,7]
	输出：49
	解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。*/
	public int maxArea(int[] height) {
		int l = 0, r = height.length - 1;
		int ans = 0;
		while (l < r) {
			int area = Math.min(height[l], height[r]) * (r - l);
			ans = Math.max(ans, area);
			if (height[l] <= height[r]) {
				++l;
			} else {
				--r;
			}
		}
		return ans;
	}

	/*17. 电话号码的字母组合
	给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
	给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
示例:
	输入："23"
	输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].*/
	public List<String> letterCombinations(String digits) {
		List<String> combinations = new ArrayList<String>();
		if (digits.length() == 0) {
			return combinations;
		}
		Map<Character, String> phoneMap = new HashMap<Character, String>() {{
			put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			put('6', "mno");
			put('7', "pqrs");
			put('8', "tuv");
			put('9', "wxyz");
		}};
		backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
		return combinations;
	}

	public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
		if (index == digits.length()) {
			combinations.add(combination.toString());
		} else {
			char digit = digits.charAt(index);
			String letters = phoneMap.get(digit);
			int lettersCount = letters.length();
			for (int i = 0; i < lettersCount; i++) {
				combination.append(letters.charAt(i));
				backtrack(combinations, phoneMap, digits, index + 1, combination);
				combination.deleteCharAt(index);
			}
		}
	}

	/*15. 三数之和
	给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
	注意：答案中不可以包含重复的三元组。
示例：

	给定数组 nums = [-1, 0, 1, 2, -1, -4]，

	满足要求的三元组集合为：
			[
			[-1, 0, 1],
			[-1, -1, 2]
			]*/

	//先排序，再两数之和
	public List<List<Integer>> threeSum(int[] nums) {
		int n = nums.length;
		//排序
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		// 枚举 a
		for (int first = 0; first < n; ++first) {
			// 需要和上一次枚举的数不相同
			if (first > 0 && nums[first] == nums[first - 1]) {
				continue;
			}
			// c 对应的指针初始指向数组的最右端
			int third = n - 1;
			int target = -nums[first];
			// 枚举 b
			for (int second = first + 1; second < n; ++second) {
				// 需要和上一次枚举的数不相同
				if (second > first + 1 && nums[second] == nums[second - 1]) {
					continue;
				}
				// 需要保证 b 的指针在 c 的指针的左侧
				while (second < third && nums[second] + nums[third] > target) {
					--third;
				}
				// 如果指针重合，随着 b 后续的增加
				// 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
				if (second == third) {
					break;
				}
				if (nums[second] + nums[third] == target) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[first]);
					list.add(nums[second]);
					list.add(nums[third]);
					ans.add(list);
				}
			}
		}
		return ans;
	}

	/*24. 两两交换链表中的节点
	给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

	你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。*/
	public ListNode swapPairs(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode temp = dummyHead;
		while (temp.next != null && temp.next.next != null) {
			ListNode node1 = temp.next;
			ListNode node2 = temp.next.next;
			temp.next = node2;
			node1.next = node2.next;
			node2.next = node1;
			temp = node1;
		}
		return dummyHead.next;
	}

	/*141. 环形链表
	给定一个链表，判断链表中是否有环。
	如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
	为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
	注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
	如果链表中存在环，则返回 true 。 否则，返回 false 。*/
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode start = head, end = head;
		while (end != null && end.next != null) {
			start = start.next;
			end = end.next.next;
			if (start == end) {
				return true;
			}
		}
		return false;
	}

	/*104. 二叉树的最大深度
	给定一个二叉树，找出其最大深度。
	二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
	说明: 叶子节点是指没有子节点的节点。
	示例：
	给定二叉树 [3,9,20,null,null,15,7]，

			3
			/ \
			9  20
			/  \
			15   7*/
	//递归
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	//用队列
	public int maxDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int ans = 0;
		while (!queue.isEmpty()) {
			ans++;
			int size = queue.size();
			while (size > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				size--;
			}
		}
		return ans;
	}


	/*38. 外观数列
	给定一个正整数 n ，输出外观数列的第 n 项。
「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
	你可以将其视作是由递归公式定义的数字字符串序列：
    countAndSay(1) = "1"
	countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
	前五项如下：

			1.     1
			2.     11
			3.     21
			4.     1211
			5.     111221
	第一项是数字 1
	描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
	描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
	描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
	描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
	要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
	例如，数字字符串 "3322251" 的描述如下图：
示例 1：

	输入：n = 1
	输出："1"
	解释：这是一个基本样例。
	示例 2：

	输入：n = 4
	输出："1211"
	解释：
	countAndSay(1) = "1"
	countAndSay(2) = 读 "1" = 一 个 1 = "11"
	countAndSay(3) = 读 "11" = 二 个 1 = "21"
	countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"*/

	//递归写法
	public static String countAndSay(int n) {
		// 递归终止条件
		if (n == 1) {
			return "1";
		}
		StringBuffer res = new StringBuffer();
		// 拿到上一层的字符串
		String str = countAndSay(n - 1);
		int length = str.length();
		// 开始指针为0
		int start = 0;
		// 注意这从起始条件要和下面长度统一
		for (int i = 1; i <= length; i++) {
			// 字符串最后一位直接拼接
			if (i == length) {
				res.append(i - start).append(str.charAt(start));
				// 直到start位的字符串和i位的字符串不同，拼接并更新start位
			} else if (str.charAt(i) != str.charAt(start) ) {
				res.append(i - start).append(str.charAt(start));
				start = i;
			}
		}
		return res.toString();
	}

	/*22. 括号生成
	数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例：
    输入：n = 3
	输出：[
			"((()))",
			"(()())",
			"(())()",
			"()(())",
			"()()()"
			]*/
	public static List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<String>();
		backtrack(ans, new StringBuilder(), 0, 0, n);
		return ans;
	}

	public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
		if (cur.length() == max * 2) {
			ans.add(cur.toString());
			return;
		}
		if (open < max) {
			cur.append('(');
			backtrack(ans, cur, open + 1, close, max);
			cur.deleteCharAt(cur.length() - 1);
		}
		if (close < open) {
			cur.append(')');
			backtrack(ans, cur, open, close + 1, max);
			cur.deleteCharAt(cur.length() - 1);
		}
	}


	/*122. 买卖股票的最佳时机 II
	给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
示例 1:
输入: [7,1,5,3,6,4]
	输出: 7
	解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
	随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
	示例 2:
输入: [1,2,3,4,5]
	输出: 4
	解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
	注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
	因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
	示例 3:

	输入: [7,6,4,3,1]
	输出: 0
	解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。*/
	public int maxProfit1(int[] prices) {
		int result=0;
		for(int i=1;i<prices.length;i++){
			result+=Math.max(0,prices[i]-prices[i-1]);
		}
		return result;
	}


	/*42. 接雨水
	给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
示例 1：
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
	输出：6
	解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
	示例 2：

	输入：height = [4,2,0,3,2,5]
	输出：9*/
	//每一个柱子的高度方向可以接的雨水的数量 = min(从当前柱子向左看的最高柱子高度, 从当前柱子向右看的最高柱子高度) - 当前柱子高度**
	public int trap(int[] height) {
		int left = 0, right = height.length - 1;
		int ans = 0;
		int left_max = 0, right_max = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				if (height[left] >= left_max) {
					left_max = height[left];
				} else {
					ans += (left_max - height[left]);
				}
				++left;
			} else {
				if (height[right] >= right_max) {
					right_max = height[right];
				} else {
					ans += (right_max - height[right]);
				}
				--right;
			}
		}
		return ans;
	}

	/*102. 二叉树的层序遍历
	给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
示例：
	二叉树：[3,9,20,null,null,15,7],
			3
			/ \
			9  20
			/  \
			15   7
	返回其层次遍历结果：

			[
			[3],
			[9,20],
			[15,7]
			]*/
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> resultList=new ArrayList<>();
		Deque<TreeNode> deque=new LinkedList<>();
		if(root!=null){
			deque.add(root);
		}
		while(!deque.isEmpty()){
			int size=deque.size();
			List<Integer> list=new ArrayList<>();
			for(int i=0;i<size;i++){
				TreeNode treeNode=deque.poll();
				list.add(treeNode.val);
				if(treeNode.left!=null){
					deque.add(treeNode.left);
				}
				if(treeNode.right!=null){
					deque.add(treeNode.right);
				}
			}
			resultList.add(list);
		}
		return resultList;
	}

	/*剑指 Offer 03. 数组中重复的数字
	找出数组中重复的数字。
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
示例 1：
	输入：
			[2, 3, 1, 0, 2, 5, 3]
	输出：2 或 3
*/
	public int findRepeatNumber(int[] nums) {
		int temp;
		for(int i=0;i<nums.length;i++){
			while (nums[i]!=i){
				if(nums[i]==nums[nums[i]]){
					return nums[i];
				}
				temp=nums[i];
				nums[i]=nums[temp];
				nums[temp]=temp;
			}
		}
		return -1;
	}


	/*198. 打家劫舍
	你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
	如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
	给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
示例 1：
	输入：[1,2,3,1]
	输出：4
	解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
	偷窃到的最高金额 = 1 + 3 = 4 。
	示例 2：

	输入：[2,7,9,3,1]
	输出：12
	解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
	偷窃到的最高金额 = 2 + 9 + 1 = 12 。*/
	public int rob(int[] nums) {
		if(nums==null||nums.length==0){
			return 0;
		}
		if(nums.length==1){
			return nums[0];
		}
		int a=nums[0],b=Math.max(nums[0],nums[1]);
		for(int i=2;i<nums.length;i++){
			int max=Math.max(a+nums[i],b);
			a=b;
			b=max;
		}
		return b;
	}

	/*58. 最后一个单词的长度
	给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
	如果不存在最后一个单词，请返回 0 。
	说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
示例:
	输入: "Hello World"
	输出: 5*/
	public int lengthOfLastWord(String s) {
//		s=s.trim();
//		int length=s.length();
//		if(length==0){
//			return 0;
//		}
//		int end=length;
//		for(int i=length-1;i>=0;i--){
//			if(!Character.isLetter(s.charAt(i))){
//				if(end==length&&i==end-1){
//					end=i;
//				}else{
//					return end-i-1;
//				}
//			}
//		}
//		return end==length?end:0;
		int end = s.length() - 1;
		while (end >= 0 && s.charAt(end) == ' ') {
			end--;
		}
		if (end < 0) {
			return 0;
		}
		int start = end;
		while (start >= 0 && s.charAt(start) != ' ') {
			start--;
		}
		return end - start;
	}

	/*46. 全排列
	给定一个 没有重复 数字的序列，返回其所有可能的全排列。
	示例:

	输入: [1,2,3]
	输出:
			[
			[1,2,3],
			[1,3,2],
			[2,1,3],
			[2,3,1],
			[3,1,2],
			[3,2,1]
			]*/
	/*public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> output = new ArrayList<Integer>();
		for (int num : nums) {
			output.add(num);
		}

		int n = nums.length;
		backtrack(n, output, res, 0);
		return res;
	}
	public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
		// 所有数都填完了
		if (first == n) {
			res.add(new ArrayList<Integer>(output));
		}
		for (int i = first; i < n; i++) {
			// 动态维护数组
			Collections.swap(output, first, i);
			// 继续递归填下一个数
			backtrack(n, output, res, first + 1);
			// 撤销操作
			Collections.swap(output, first, i);
		}
	}*/

	public List<List<Integer>> permute(int[] nums) {
		int len = nums.length;
		// 使用一个动态数组保存所有可能的全排列
		List<List<Integer>> res = new ArrayList<>();
		if (len == 0) {
			return res;
		}
		boolean[] used = new boolean[len];
		List<Integer> path = new ArrayList<>();

		dfs(nums, len, 0, path, used, res);
		return res;
	}

	private void dfs(int[] nums, int len, int depth,
					 List<Integer> path, boolean[] used,
					 List<List<Integer>> res) {
		if (depth == len) {
			res.add(path);
			return;
		}
		// 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
		for (int i = 0; i < len; i++) {
			if (!used[i]) {
				path.add(nums[i]);
				used[i] = true;

				dfs(nums, len, depth + 1, path, used, res);
				// 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
				used[i] = false;
				path.remove(path.size() - 1);
			}
		}
	}

	/*将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z 字形排列。
比如输入字符串为 "LEETCODEISHIRING"行数为 3 时，排列如下：
	L   C   I   R
	E T O E S I I G
	E   D   H   N
	之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
	请你实现这个将字符串进行指定行数变换的函数：
	string convert(string s, int numRows);
	示例1:
	输入: s = "LEETCODEISHIRING", numRows = 3
	输出: "LCIRETOESIIGEDHN"*/

	public String convert(String s, int numRows) {
		if (numRows < 2) {
			return s;
		}
		List<StringBuilder> rows = new ArrayList<StringBuilder>();
		for (int i = 0; i < numRows; i++) {
			rows.add(new StringBuilder());
		}
		int i = 0, flag = -1;
		for (char c : s.toCharArray()) {
			rows.get(i).append(c);
			if (i == 0 || i == numRows - 1) {
				flag = -flag;
			}
			i += flag;
		}
		StringBuilder res = new StringBuilder();
		for (StringBuilder row : rows) {
			res.append(row);
		}
		return res.toString();
	}

	/*55. 跳跃游戏
	给定一个非负整数数组，你最初位于数组的第一个位置。
	数组中的每个元素代表你在该位置可以跳跃的最大长度。
	判断你是否能够到达最后一个位置。
	示例 1:
	输入: [2,3,1,1,4]
	输出: true
	解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
	示例 2:
	输入: [3,2,1,0,4]
	输出: false
	解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
*/
	public boolean canJump(int[] nums) {
		int n = nums.length;
		int rightmost = 0;
		for (int i = 0; i < n; ++i) {
			if (i <= rightmost) {
				rightmost = Math.max(rightmost, i + nums[i]);
				if (rightmost >= n - 1) {
					return true;
				}
			}
		}
		return false;
	}

	/*56. 合并区间
	给出一个区间的集合，请合并所有重叠的区间。
示例 1:
	输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
	输出: [[1,6],[8,10],[15,18]]
	解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
	示例 2:
	输入: intervals = [[1,4],[4,5]]
	输出: [[1,5]]
	解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。*/

	//list转换为二维数组：list.toArray(new int[0][])这种写法确实有性能上的提升，当传入数组的长度小于list的元素个数size时，是默认使用size作为数组复制的长度
	public int[][] merge(int[][] intervals) {
		List<int[]> res = new ArrayList<>();
		if (intervals == null || intervals.length == 0) {
			return res.toArray(new int[0][]);
		}
		// 对起点终点进行排序
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int i = 0;
		while (i < intervals.length) {
			int left = intervals[i][0];
			int right = intervals[i][1];
			// 如果有重叠，循环判断哪个起点满足条件
			while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
				i++;
				right = Math.max(right, intervals[i][1]);
			}
			// 将现在的区间放进res里面
			res.add(new int[]{left, right});
			// 接着判断下一个区间
			i++;
		}
		return res.toArray(new int[0][]);
	}

	/*169. 多数元素
	给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
	你可以假设数组是非空的，并且给定的数组总是存在多数元素。
示例 1:

	输入: [3,2,3]
	输出: 3
	示例 2:

	输入: [2,2,1,1,1,2,2]
	输出: 2*/
	public int majorityElement(int[] nums) {
		/*Arrays.sort(nums);
		return nums[nums.length >> 1];*/

		//摩比投票法
		int count = 0;
		Integer candidate = null;

		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count += (num == candidate) ? 1 : -1;
		}

		return candidate;
	}

	/*34. 在排序数组中查找元素的第一个和最后一个位置
	给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
	如果数组中不存在目标值，返回 [-1, -1]。

	示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
	输出: [3,4]
	示例 2:

	输入: nums = [5,7,7,8,8,10], target = 6
	输出: [-1,-1]*/
	public int[] searchRange(int[] nums, int target) {
		int[] targetRange = {-1, -1};
		//left为true找的就是目标值最左边的坐标
		int leftIdx = extremeInsertionIndex(nums, target, true);
		if (leftIdx == nums.length || nums[leftIdx] != target) {
			return targetRange;
		}

		targetRange[0] = leftIdx;
		//left为false找的就是目标值最右边的坐标
		targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

		return targetRange;
	}

	private int extremeInsertionIndex(int[] nums, int target, boolean left) {
		int lo = 0;
		int hi = nums.length;

		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] > target || (left && target == nums[mid])) {
				hi = mid;
			}else {
				lo = mid+1;
			}
		}

		return lo;
	}



	/*剑指 Offer 57 - II. 和为s的连续正数序列
	输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）
	序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
示例 1：
    输入：target = 9
	输出：[[2,3,4],[4,5]]
	示例 2：
	输入：target = 15
	输出：[[1,2,3,4,5],[4,5,6],[7,8]]*/
	public int[][] findContinuousSequence(int target) {
		int i = 1; // 滑动窗口的左边界
		int j = 1; // 滑动窗口的右边界
		int sum = 0; // 滑动窗口中数字的和
		List<int[]> res = new ArrayList<>();
		while (i <= target / 2) {
			if (sum < target) {
				// 右边界向右移动
				sum += j;
				j++;
			} else if (sum > target) {
				// 左边界向右移动
				sum -= i;
				i++;
			} else {
				// 记录结果
				int[] arr = new int[j-i];
				for (int k = i; k < j; k++) {
					arr[k-i] = k;
				}
				res.add(arr);
				// 左边界向右移动
				sum -= i;
				i++;
			}
		}
		return res.toArray(new int[res.size()][]);
	}

	/*101. 对称二叉树
	给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

			1
			/ \
			2   2
			/ \ / \
			3  4 4  3

	但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

			1
			/ \
			2   2
			\   \
			3    3*/
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetricTree(root.left, root.right);
	}

	public boolean isSymmetricTree(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		if (left.val != right.val) {
			return false;
		}
		return isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left);
	}

	//迭代法
	public boolean isSymmetric1(TreeNode root) {
		return check(root, root);
	}

	public boolean check(TreeNode u, TreeNode v) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(u);
		q.add(v);
		while (!q.isEmpty()) {
			u = q.poll();
			v = q.poll();
			if (u == null && v == null) {
				continue;
			}
			if ((u == null || v == null) || (u.val != v.val)) {
				return false;
			}

			q.add(u.left);
			q.add(v.right);
			q.add(u.right);
			q.add(v.left);
		}
		return true;
	}

	/*33. 搜索旋转排序数组
	给你一个整数数组 nums ，和一个整数 target 。
	该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
	请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
示例 1：

	输入：nums = [4,5,6,7,0,1,2], target = 0
	输出：4
	示例 2：

	输入：nums = [4,5,6,7,0,1,2], target = 3
	输出：-1
	示例 3：

	输入：nums = [1], target = 0
	输出：-1*/
	public int search(int[] nums, int target) {
		int length = nums.length;
		if (length == 0) {
			return -1;
		}
		if (length == 1) {
			return nums[0] == target ? 0 : -1;
		}
		int left = 0, right = length - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (nums[mid] == target) {
				return mid;
			}
			//左边是排序
			if (nums[left] <= nums[mid]) {
				//看目标数是否在左边
				if (target < nums[mid] && target >= nums[left]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				//右边是排序，看目标数是否在排序中
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

	/*136. 只出现一次的数字
	给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

	说明：
	你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
	示例 1:
	输入: [2,2,1]
	输出: 1
	示例 2:
	输入: [4,1,2,1,2]
	输出: 4*/
	public int singleNumber(int[] nums) {
		if(nums==null||nums.length==0){
			return -1;
		}
		int result=0;
		for(int i=0;i<nums.length;i++){
			result=result^nums[i];
		}
		return result;
	}

	/*23. 合并K个升序链表
	给你一个链表数组，每个链表都已经按升序排列。
	请你将所有链表合并到一个升序链表中，返回合并后的链表。
示例 1：
	输入：lists = [[1,4,5],[1,3,4],[2,6]]
	输出：[1,1,2,3,4,4,5,6]
	解释：链表数组如下：
			[
			1->4->5,
			1->3->4,
			2->6
			]
	将它们合并到一个有序链表中得到。
			1->1->2->3->4->4->5->6
	示例 2：
	输入：lists = []
	输出：[]
	示例 3：

	输入：lists = [[]]
	输出：[]*/
	//分治算法
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {return null;}
		return merge(lists, 0, lists.length - 1);
	}

	private ListNode merge(ListNode[] lists, int left, int right) {
		if (left == right) {return lists[left];}
		int mid = left + (right - left) / 2;
		ListNode l1 = merge(lists, left, mid);
		ListNode l2 = merge(lists, mid + 1, right);
		return mergeTwoLists1(l1, l2);
	}

	private ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if (l1 == null) {return l2;}
		if (l2 == null) {return l1;}
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists1(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists1(l1,l2.next);
			return l2;
		}
	}

	/*64. 最小路径和
	给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
	说明：每次只能向下或者向右移动一步。
	示例：
	1 3 1
	1 5 1
	4 2 1
	输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
	输出：7
	解释：因为路径 1→3→1→1→1 的总和最小。
	输入：grid = [[1,2,3],[4,5,6]]
	输出：12*/
	//动态规划
	public int minPathSum(int[][] grid) {
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(i==0&&j==0){
					continue;
				}
				if(i==0){
					grid[i][j]+=grid[i][j-1];
				}else if(j==0){
					grid[i][j]+=grid[i-1][j];
				}else{
					grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
				}
			}
		}
		return grid[grid.length-1][grid[0].length-1];
	}
	/*94. 二叉树的中序遍历
	给定一个二叉树的根节点 root ，返回它的 中序 遍历。
	输入：root = [1,null,2,3]
	输出：[1,3,2]
	输入：root = []
	输出：[]
	示例 3：
	输入：root = [1]
	输出：[1]*/

	public List<Integer> inorderTraversal(TreeNode root) {
		//用栈迭代（面试时可以使用迭代方案）
		/*List<Integer> ret = new ArrayList<>();
		if (root == null) return ret;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			TreeNode node = stack.pop();
			ret.add(node.val);
			cur = node.right;
		}
		return ret;*/

		//递归。（视频讲解里有比较全的二叉树知识点总结）
		List<Integer> result = new ArrayList<>();
		inorder(root, result);
		return result;
	}

	public void inorder(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		inorder(root.left, res);
		res.add(root.val);
		inorder(root.right, res);
	}

	/*234. 回文链表
	请判断一个链表是否为回文链表。
	示例 1:

	输入: 1->2
	输出: false
	示例 2:

	输入: 1->2->2->1
	输出: true*/
	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		//反转链表
		ListNode secondHalfStart = reverse(slow.next);
		//// 判断是否回文
		ListNode p1 = head, p2 = secondHalfStart;
		while (p2 != null) {
			if (p1.val != p2.val) {
				return false;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		//还原链表
		slow.next = reverse(secondHalfStart);
		return true;

	}

	public ListNode reverse(ListNode root) {
		if (root == null) {
			return root;
		}
		ListNode pre = null, cur = null;
		while (root != null) {
			cur = root.next;
			root.next = pre;
			pre = root;
			root = cur;
		}
		return pre;
	}

	//此题细节未看，涉及多个排序，可以好好看下详细方案
	/*215. 数组中的第K个最大元素
	在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
	示例 1:
	输入: [3,2,1,5,6,4] 和 k = 2
	输出: 5
	示例 2:
	输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
	输出: 4*/

	//堆排序
	/*public int findKthLargest(int[] nums, int k) {
		int heapSize = nums.length;
		buildMaxHeap(nums, heapSize);
		for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
			swap(nums, 0, i);
			--heapSize;
			maxHeapify(nums, 0, heapSize);
		}
		return nums[0];
	}

	public void buildMaxHeap(int[] a, int heapSize) {
		for (int i = heapSize / 2; i >= 0; --i) {
			maxHeapify(a, i, heapSize);
		}
	}

	public void maxHeapify(int[] a, int i, int heapSize) {
		int l = i * 2 + 1, r = i * 2 + 2, largest = i;
		if (l < heapSize && a[l] > a[largest]) {
			largest = l;
		}
		if (r < heapSize && a[r] > a[largest]) {
			largest = r;
		}
		if (largest != i) {
			swap(a, i, largest);
			maxHeapify(a, largest, heapSize);
		}
	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}*/

	//快排思想
	public static int findKthLargest(int[] nums, int k) {
		int len = nums.length;
		int left = 0;
		int right = len - 1;

		// 转换一下，第 k 大元素的索引是 len - k
		int target = len - k;

		while (true) {
			//先从第一个值开始
			int index = partition(nums, left, right);
			if (index == target) {
				return nums[index];
				//向右找
			} else if (index < target) {
				left = index + 1;
			} else {
				//向左找
				right = index - 1;
			}
		}
	}

	/*
	 * 在数组 nums 的子区间 [left, right] 执行 partition 操作，返回 nums[left] 排序以后应该在的位置
	 * 在遍历过程中保持循环不变量的语义
	 * 1、[left + 1, j] < nums[left]
	 * 2、(j, i] >= nums[left]
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	public static int partition(int[] nums, int left, int right) {
		int pivot = nums[left];
		int j = left;
		for (int i = left + 1; i <= right; i++) {
			if (nums[i] < pivot) {
				// 小于 pivot 的元素都被交换到前面
				j++;
				//自己加的
				if (i != j) {
					swap(nums, j, i);
				}
			}
		}
		// 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
		swap(nums, j, left);
		// 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
		return j;
	}

	private static void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}

	/*62. 不同路径
	一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
	机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
	问总共有多少条不同的路径？
	输入: m = 3, n = 2
	输出: 3
	解释:
	从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右

	//自己写的
	 */
	public int uniquePaths(int m, int n) {
		int[][] arr=new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(i!=0&&j!=0){
					arr[i][j]=arr[i-1][j]+arr[i][j-1];
				}else{
					arr[i][j]=1;
				}
			}
		}
		return arr[n-1][m-1];
	}

	/*125. 验证回文串
	给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
	说明：本题中，我们将空字符串定义为有效的回文串。
	示例 1:
	输入: "A man, a plan, a canal: Panama"
	输出: true
	示例 2:
	输入: "race a car"
	输出: false*/
	public boolean isPalindrome(String s) {
		if (s==null||s.length() == 0){
			return true;
		}
		int l = 0, r = s.length() - 1;
		while (l < r) {
			// 从头和尾开始向中间遍历
			if (!Character.isLetterOrDigit(s.charAt(l))) {// 字符不是字母和数字的情况
				l++;
			} else if (!Character.isLetterOrDigit(s.charAt(r))) {// 字符不是字母和数字的情况
				r--;
			} else {
				// 判断二者是否相等
				if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
					return false;
				}
				l++;
				r--;
			}
		}
		return true;
	}

	/*200. 岛屿数量
	给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
	岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
	此外，你可以假设该网格的四条边均被水包围。
示例 1：

	输入：grid = [
			["1","1","1","1","0"],
			["1","1","0","1","0"],
			["1","1","0","0","0"],
			["0","0","0","0","0"]
			]
	输出：1
	示例 2：

	输入：grid = [
			["1","1","0","0","0"],
			["1","1","0","0","0"],
			["0","0","1","0","0"],
			["0","0","0","1","1"]
			]
	输出：3*/
	//广度优先遍历
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int nr = grid.length;
		int nc = grid[0].length;
		int num_islands = 0;
		for (int r = 0; r < nr; ++r) {
			for (int c = 0; c < nc; ++c) {
				if (grid[r][c] == '1') {
					++num_islands;
					grid[r][c] = '0';
					Queue<int[]> neighbors = new LinkedList<>();
					neighbors.add(new int[]{r, c});
					while (!neighbors.isEmpty()) {
						int[] arr = neighbors.poll();
						int row = arr[0];
						int col = arr[1];
						if (row - 1 >= 0 && grid[row - 1][col] == '1') {
							neighbors.add(new int[]{row - 1, col});
							grid[row - 1][col] = '0';
						}
						if (row + 1 < nr && grid[row + 1][col] == '1') {
							neighbors.add(new int[]{row + 1, col});
							grid[row + 1][col] = '0';
						}
						if (col - 1 >= 0 && grid[row][col - 1] == '1') {
							neighbors.add(new int[]{row, col - 1});
							grid[row][col - 1] = '0';
						}
						if (col + 1 < nc && grid[row][col + 1] == '1') {
							neighbors.add(new int[]{row, col + 1});
							grid[row][col + 1] = '0';
						}
					}
				}
			}
		}
		return num_islands;
	}


	/*67. 二进制求和
	给你两个二进制字符串，返回它们的和（用二进制表示）。
	输入为 非空 字符串且只包含数字 1 和 0。
示例 1:

	输入: a = "11", b = "1"
	输出: "100"
	示例 2:
	输入: a = "1010", b = "1011"
	输出: "10101"*/
	public String addBinary(String a, String b) {
		StringBuilder ans = new StringBuilder();
		int ca = 0;
		for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
			int sum = ca;
			sum += i >= 0 ? a.charAt(i) - '0' : 0;
			sum += j >= 0 ? b.charAt(j) - '0' : 0;
			ans.append(sum % 2);
			ca = sum / 2;
		}
		ans.append(ca == 1 ? ca : "");
		return ans.reverse().toString();
	}

	/*25. K 个一组翻转链表
	给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
	k 是一个正整数，它的值小于或等于链表的长度。
	如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
示例：
	给你这个链表：1->2->3->4->5
	当 k = 2 时，应当返回: 2->1->4->3->5
	当 k = 3 时，应当返回: 3->2->1->4->5
	说明：
	你的算法只能使用常数的额外空间。
	你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
*/

	//对答案改造了下
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode hair = new ListNode(0);
		hair.next = head;
		ListNode pre = hair;

		while (head != null) {
			ListNode tail = pre;
			// 查看剩余部分长度是否大于等于 k
			for (int i = 0; i < k; ++i) {
				tail = tail.next;
				if (tail == null) {
					return hair.next;
				}
			}
			myReverse1(head, tail);
			pre.next=tail;
			pre=head;
			head=head.next;
		}

		return hair.next;
	}

	public ListNode[] myReverse(ListNode head, ListNode tail) {
		ListNode prev = tail.next;
		ListNode p = head;
		while (prev != tail) {
			ListNode nex = p.next;
			p.next = prev;
			prev = p;
			p = nex;
		}
		return new ListNode[]{tail, head};
	}

	//不止反转，还需指向后一个节点
	public void myReverse1(ListNode head,ListNode tail){
		ListNode prev=tail.next;
		ListNode p=head;
		while(prev!=tail){
			ListNode nex = p.next;
			p.next = prev;
			prev = p;
			p = nex;
		}
	}


	/*98. 验证二叉搜索树
	给定一个二叉树，判断其是否是一个有效的二叉搜索树。
	假设一个二叉搜索树具有如下特征：
	节点的左子树只包含小于当前节点的数。
	节点的右子树只包含大于当前节点的数。
	所有左子树和右子树自身必须也是二叉搜索树。
	示例 1:
	输入:
			2
			/ \
			1   3
	输出: true
	示例 2:

	输入:
			5
			/ \
			1   4
			/ \
			3   6
	输出: false
	解释: 输入为: [5,1,4,null,null,3,6]。
	根节点的值为 5 ，但是其右子节点值为 4 。*/

	//方法：因为中序遍历是升序的，所以可以利用这个特点来写
	public boolean isValidBST(TreeNode root) {
		double pre = -Double.MAX_VALUE;
		Deque<TreeNode> stack=new LinkedList<>();
		while(!stack.isEmpty()||root!=null){
			while(root!=null){
				stack.push(root);
				root=root.left;
			}
			root=stack.pop();
			if(root.val<=pre){
				return false;
			}
			pre=root.val;
			root=root.right;
		}
		return true;
	}

	//递归写法
	public boolean isValidBST1(TreeNode root) {
		return helper(root, null, null);
	}

	public boolean helper(TreeNode node, Integer lower, Integer upper) {
		if (node == null) {
			return true;
		}

		int val = node.val;
		if (lower != null && val <= lower) {
			return false;
		}
		if (upper != null && val >= upper) {
			return false;
		}

		if (!helper(node.right, val, upper)) {
			return false;
		}
		if (!helper(node.left, lower, val)) {
			return false;
		}
		return true;
	}

	/*994. 腐烂的橘子
	在给定的网格中，每个单元格可以有以下三个值之一：

	值 0 代表空单元格；
	值 1 代表新鲜橘子；
	值 2 代表腐烂的橘子。
	每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。

	返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
示例 1：
	输入：[[2,1,1],[1,1,0],[0,1,1]]
	输出：4
	示例 2：

	输入：[[2,1,1],[0,1,1],[1,0,1]]
	输出：-1
	解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
	示例 3：

	输入：[[0,2]]
	输出：0
	解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。*/

	//广度优先遍历，和上面岛屿题的原理是一样的
	public int orangesRotting(int[][] grid) {
		//新鲜橘子的数量
		int count=0;
		Queue<int[]> queue=new LinkedList<>();
		int M=grid.length,N=grid[0].length;
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				if(grid[i][j]==1){
					count++;
				}else if(grid[i][j]==2){
					queue.add(new int[]{i,j});
				}
			}
		}
		//轮数
		int round=0;
		while (count > 0 && !queue.isEmpty()) {
			round++;
			int size=queue.size();
			for(int i=0;i<size;i++){
				int[] arr=queue.poll();
				int m=arr[0];
				int n=arr[1];
				//上下左右四个点
				if(m-1>=0&&grid[m-1][n]==1){
					count--;
					grid[m-1][n]=2;
					queue.add(new int[]{m-1,n});
				}
				if(m+1<M&&grid[m+1][n]==1){
					count--;
					grid[m+1][n]=2;
					queue.add(new int[]{m+1,n});
				}
				if(n-1>=0&&grid[m][n-1]==1){
					count--;
					grid[m][n-1]=2;
					queue.add(new int[]{m,n-1});
				}
				if(n+1<N&&grid[m][n+1]==1){
					count--;
					grid[m][n+1]=2;
					queue.add(new int[]{m,n+1});
				}
			}
		}
		if(count>0){
			return -1;
		}
		return round;
	}

	/*剑指 Offer 40. 最小的k个数
	输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
示例 1：
	输入：arr = [3,2,1], k = 2
	输出：[1,2] 或者 [2,1]
	示例 2：
	输入：arr = [0,1,2,1], k = 1
	输出：[0]
*/
	//自己写法，用的快排，和上面那个找倒数第k个大的数思想一样（答案也有这种思想，然后或者是使用堆排序）
	public int[] getLeastNumbers(int[] arr, int k) {
		if(k==0){
			return new int[]{};
		}
		int left=0,right=arr.length-1;
		while (true) {
			//先从第一个值开始
			int index = partition(arr, left, right);
			if (index == k-1) {
				return Arrays.copyOfRange(arr,0,k);
				//向右找
			} else if (index < k-1) {
				left = index + 1;
			} else {
				//向左找
				right = index - 1;
			}
		}
	}

	/*我们用一个大根堆实时维护数组的前 kk 小值。首先将前 kk 个数插入大根堆中，随后从第 k+1k+1 个数开始遍历，如果当前遍历到的数比大根堆的堆顶的数要小，
	就把堆顶的数弹出，再插入当前遍历到的数。最后将大根堆里的数存入数组返回即可。*/
	public int[] getLeastNumbers1(int[] arr, int k) {
		int[] vec = new int[k];
		if (k == 0) { // 排除 0 的情况
			return vec;
		}
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer num1, Integer num2) {
				return num2 - num1;
			}
		});
		for (int i = 0; i < k; ++i) {
			queue.offer(arr[i]);
		}
		for (int i = k; i < arr.length; ++i) {
			if (queue.peek() > arr[i]) {
				queue.poll();
				queue.offer(arr[i]);
			}
		}
		for (int i = 0; i < k; ++i) {
			vec[i] = queue.poll();
		}
		return vec;
	}

	/*69. x 的平方根
	实现 int sqrt(int x) 函数。
	计算并返回 x 的平方根，其中 x 是非负整数。
	由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
	示例 1:
	输入: 4
	输出: 2
	示例 2:
	输入: 8
	输出: 2
	说明: 8 的平方根是 2.82842...,
	由于返回类型是整数，小数部分将被舍去。
*/
	//二分查找
	public int mySqrt(int x) {
		int l = 0, r = x, ans = -1;
		while (l <= r) {
			int mid = (r+l) / 2;
			if ((long) mid * mid <= x) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return ans;
	}

	/*100. 相同的树
	给定两个二叉树，编写一个函数来检验它们是否相同。

	如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

	示例 1:

	输入:       1         1
			/ \       / \
			2   3     2   3

			[1,2,3],   [1,2,3]

	输出: true
	示例 2:

	输入:      1          1
			/           \
			2             2

			[1,2],     [1,null,2]

	输出: false*/
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}


	//广度优先遍历
	public boolean isSameTree1(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		}
		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
		queue1.offer(p);
		queue2.offer(q);
		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			TreeNode node1 = queue1.poll();
			TreeNode node2 = queue2.poll();
			if (node1.val != node2.val) {
				return false;
			}
			TreeNode left1 = node1.left, right1 = node1.right, left2 = node2.left, right2 = node2.right;
			if (left1 == null ^ left2 == null) {
				return false;
			}
			if (right1 == null ^ right2 == null) {
				return false;
			}
			if (left1 != null) {
				queue1.offer(left1);
			}
			if (right1 != null) {
				queue1.offer(right1);
			}
			if (left2 != null) {
				queue2.offer(left2);
			}
			if (right2 != null) {
				queue2.offer(right2);
			}
		}
		return queue1.isEmpty() && queue2.isEmpty();
	}


	/*剑指 Offer 22. 链表中倒数第k个节点
	输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
	它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
示例：
	给定一个链表: 1->2->3->4->5, 和 k = 2.

	返回链表 4->5.*/
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode p1 = head;
		while (p1 != null && k > 0) {
			p1 = p1.next;
			k--;
		}
		ListNode p2 = head;
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}

	/*78. 子集
	给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
	说明：解集不能包含重复的子集。
	示例:
	输入: nums = [1,2,3]
	输出:
			[
			[3],
			[1],
			[2],
			[1,2,3],
			[1,3],
			[2,3],
			[1,2],
			[]
			]*/

	public static List<List<Integer>> subsets(int[] nums) {
		List<Integer> t = new ArrayList<Integer>();
		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		int n = nums.length;
		for (int mask = 0; mask < (1 << n); ++mask) {
			t.clear();
			for (int i = 0; i < n; ++i) {
				if ((mask & (1 << i)) != 0) {
					t.add(nums[i]);
				}
			}
			ans.add(t);
		}
		return ans;
	}


	/*344. 反转字符串
	编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
	不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
	你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
示例 1：

	输入：["h","e","l","l","o"]
	输出：["o","l","l","e","h"]
	示例 2：

	输入：["H","a","n","n","a","h"]
	输出：["h","a","n","n","a","H"]*/
	public void reverseString(char[] s) {
		int left=0,right=s.length-1;
		while(left<right){
			char temp=s[left];
			s[left]=s[right];
			s[right]=temp;
			left++;
			right--;
		}
	}

	/*39. 组合总和
	给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
	candidates 中的数字可以无限制重复被选取。
	说明
	所有数字（包括 target）都是正整数。
	解集不能包含重复的组合。
	示例 1：

	输入：candidates = [2,3,6,7], target = 7,
	所求解集为：
			[
			[7],
			[2,2,3]
			]
	示例 2：

	输入：candidates = [2,3,5], target = 8,
	所求解集为：
			[
			[2,2,2,2],
			[2,3,3],
			[3,5]
			]*/
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		int len = candidates.length;
		List<List<Integer>> res = new ArrayList<>();
		if (len == 0) {
			return res;
		}

		Deque<Integer> path = new ArrayDeque<>();
		dfs(candidates, 0, len, target, path, res);
		return res;
	}

	/*
	 * @param candidates 候选数组
	 * @param begin      搜索起点
	 * @param len        冗余变量，是 candidates 里的属性，可以不传
	 * @param target     每减去一个元素，目标值变小
	 * @param path       从根结点到叶子结点的路径，是一个栈
	 * @param res        结果集列表
	 */
	//回溯法
	private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
		// target 为负数和 0 的时候不再产生新的孩子结点
		if (target < 0) {
			return;
		}
		if (target == 0) {
			res.add(new ArrayList<>(path));
			return;
		}

		// 重点理解这里从 begin 开始搜索的语意
		for (int i = begin; i < len; i++) {
			path.addLast(candidates[i]);

			// 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
			dfs(candidates, i, len, target - candidates[i], path, res);

			// 状态重置
			path.removeLast();
		}
	}


	/*75. 颜色分类
	给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
	此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
进阶：
	你可以不使用代码库中的排序函数来解决这道题吗？
	你能想出一个仅使用常数空间的一趟扫描算法吗？
	示例 1：
	输入：nums = [2,0,2,1,1,0]
	输出：[0,0,1,1,2,2]
	示例 2：
	输入：nums = [2,0,1]
	输出：[0,1,2]
	示例 3：
	输入：nums = [0]
	输出：[0]
	示例 4：
	输入：nums = [1]
	输出：[1]*/
	public void sortColors(int[] nums) {
		int length=nums.length;
		if(length==0||length==1){
			return;
		}
		int left=0,right=length-1;
		int flag=-1;
		while(left<=right){
			if(nums[left]==0){
				flag++;
				if(flag!=left){
					swap(nums,left,flag);
				}
				left++;
			}else if(nums[left]==1){
				left++;
			}else{
				swap(nums,left,right);
				right--;
			}
		}
	}


	/*111. 二叉树的最小深度
	给定一个二叉树，找出其最小深度。
	最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
	说明：叶子节点是指没有子节点的节点。
	示例 1：
	输入：root = [3,9,20,null,null,15,7]
	输出：2
	示例 2：
	输入：root = [2,null,3,null,4,null,5,null,6]
	输出：5*/
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null) {
			return 1 + minDepth(root.right);
		}
		if (root.right == null) {
			return 1 + minDepth(root.left);
		}
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

	/*392. 判断子序列
	给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
	字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
	示例 1:
	s = "abc", t = "ahbgdc"
	返回 true.
	示例 2:
	s = "axc", t = "ahbgdc"
	返回 false.*/
	public boolean isSubsequence(String s, String t) {
		int i=0,j=s.length();
		int m=0,n=t.length();
		while(i<j&&m<n){
			if(t.charAt(m)==s.charAt(i)){
				i++;
			}
			m++;
		}
		return i==j;
	}

	/*226. 翻转二叉树
	翻转一棵二叉树。
	示例：
	输入：
			4
			/   \
			2     7
			/ \   / \
			1   3 6   9
	输出：
			4
			/   \
			7     2
			/ \   / \
			9   6 3   1*/
	public TreeNode invertTree(TreeNode root) {
		if(root==null){
			return null;
		}
		TreeNode treeNode=root.left;
		root.left=invertTree(root.right);
		root.right=invertTree(treeNode);
		return root;
	}

	/*剑指 Offer 04. 二维数组中的查找
	在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
示例:
现有矩阵 matrix 如下：

			[
			[1,   4,  7, 11, 15],
			[2,   5,  8, 12, 19],
			[3,   6,  9, 16, 22],
			[10, 13, 14, 17, 24],
			[18, 21, 23, 26, 30]
			]*/
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if (matrix == null || matrix.length <= 0) {
			return false;
		}
		int row = matrix.length, col = matrix[0].length;
		int i = row - 1, j = 0;
		while (i >= 0 && j < col) {
			if (matrix[i][j] == target) {
				return true;
			}
			if (matrix[i][j] < target) {
				j++;
			} else {
				i--;
			}
		}
		return false;
	}

	/*31. 下一个排列
	实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
	如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
	必须 原地 修改，只允许使用额外常数空间。
	示例 1：
	输入：nums = [1,2,3]
	输出：[1,3,2]
	示例 2：
	输入：nums = [3,2,1]
	输出：[1,2,3]
	示例 3：
	输入：nums = [1,1,5]
	输出：[1,5,1]
	示例 4：
	输入：nums = [1]
	输出：[1]*/
	public void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int j = nums.length - 1;
			while (j > i && nums[i] >= nums[j]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
	}

	public void reverse(int[] nums, int start) {
		int left = start, right = nums.length - 1;
		while (left < right) {
			swap(nums, left, right);
			left++;
			right--;
		}
	}

	/*剑指 Offer 05. 替换空格
	请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
示例 1：
	输入：s = "We are happy."
	输出："We%20are%20happy."*/
	public String replaceSpace(String s) {
		StringBuffer stringBuffer=new StringBuffer();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==' '){
				stringBuffer.append("%20");
			}else{
				stringBuffer.append(s.charAt(i));
			}
		}
		return stringBuffer.toString();
	}

	/*876. 链表的中间结点
	给定一个头结点为 head 的非空单链表，返回链表的中间结点。
	如果有两个中间结点，则返回第二个中间结点。
示例 1：
	输入：[1,2,3,4,5]
	输出：此列表中的结点 3 (序列化形式：[3,4,5])
	返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
	注意，我们返回了一个 ListNode 类型的对象 ans，这样：
	ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
			示例 2：

	输入：[1,2,3,4,5,6]
	输出：此列表中的结点 4 (序列化形式：[4,5,6])
	由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。*/
	public ListNode middleNode(ListNode head) {
		ListNode slow=head,fast=head;
		while(fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}

	/*剑指 Offer 06. 从尾到头打印链表
	输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
示例 1：
	输入：head = [1,3,2]
	输出：[2,3,1]*/
	public int[] reversePrint(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode temp = head;
		while (temp != null) {
			stack.push(temp);
			temp = temp.next;
		}
		int[] print = new int[stack.size()];
		for (int i = 0; i < print.length; i++) {
			print[i] = stack.pop().val;
		}
		return print;
	}

	/*1103. 分糖果 II
	排排坐，分糖果。
	我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
	给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
	然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
	重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
	返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
示例 1：
	输入：candies = 7, num_people = 4
	输出：[1,2,3,1]
	解释：
	第一次，ans[0] += 1，数组变为 [1,0,0,0]。
	第二次，ans[1] += 2，数组变为 [1,2,0,0]。
	第三次，ans[2] += 3，数组变为 [1,2,3,0]。
	第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
	示例 2：

	输入：candies = 10, num_people = 3
	输出：[5,2,3]
	解释：
	第一次，ans[0] += 1，数组变为 [1,0,0]。
	第二次，ans[1] += 2，数组变为 [1,2,0]。
	第三次，ans[2] += 3，数组变为 [1,2,3]。
	第四次，ans[0] += 4，最终数组变为 [5,2,3]。*/
	public int[] distributeCandies(int candies, int num_people) {
		int[] ans = new int[num_people];
		int i = 0;
		while (candies != 0) {
			ans[i % num_people] += Math.min(candies, i + 1);
			candies -= Math.min(candies, i + 1);
			i ++;
		}
		return ans;
	}

	/*120. 三角形最小路径和
	给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
	相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
	例如，给定三角形：

			[
			[2],
			[3,4],
			[6,5,7],
			[4,1,8,3]
			]
	自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。*/
	public int minimumTotal(List<List<Integer>> triangle) {
		int row=triangle.size();
		int[][] f = new int[row][row];
		for(int i=0;i<row;i++){
			for(int j=0;j<triangle.get(i).size();j++){
				if(i==0&&j==0){
					f[i][j]=triangle.get(i).get(j);
					continue;
				}else if(j==0){
					f[i][j]=triangle.get(i).get(j)+f[i-1][j];
				}else if(j==triangle.get(i).size()-1){
					f[i][j]=triangle.get(i).get(j)+f[i-1][j-1];
				}else{
					f[i][j]=triangle.get(i).get(j)+Math.min(f[i-1][j-1],f[i-1][j]);
				}
			}
		}
		int result=f[row-1][0];
		for(int m=1;m<f[row-1].length;m++){
			result=Math.min(result,f[row-1][m]);
		}
		return result;
	}
    /*	144. 二叉树的前序遍历
	给你二叉树的根节点 root ，返回它节点值的 前序 遍历。*/
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.pop();
			list.add(treeNode.val);
			if (treeNode.right != null) {
				stack.push(treeNode.right);
			}
			if (treeNode.left != null) {
				stack.push(treeNode.left);
			}
		}
		return list;
	}

	//递归写法
	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		preorder(root, res);
		return res;
	}

	public void preorder(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		res.add(root.val);
		preorder(root.left, res);
		preorder(root.right, res);
	}

	/*167. 两数之和 II - 输入有序数组
	给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
	函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
	说明:
	返回的下标值（index1 和 index2）不是从零开始的。
	你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
	示例:
	输入: numbers = [2, 7, 11, 15], target = 9
	输出: [1,2]
	解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。*/

	//（此方法对不排序的数组或者排序的数组都可以使用，不过最好排序的用下面双指针法，这样空间复杂度更低）
	public int[] twoSum1(int[] numbers, int target) {
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<numbers.length;i++){
			if(map.get(target-numbers[i])!=null){
				return new int[]{map.get(target-numbers[i]),i+1};
			}
			map.put(numbers[i], i+1);
		}
		return new int[]{-1,-1};
	}

	//双指针法(针对升序的数组可以使用)
	public int[] twoSum2(int[] numbers, int target) {
		int low = 0, high = numbers.length - 1;
		while (low < high) {
			int sum = numbers[low] + numbers[high];
			if (sum == target) {
				return new int[]{low + 1, high + 1};
			} else if (sum < target) {
				++low;
			} else {
				--high;
			}
		}
		return new int[]{-1, -1};
	}

	/*300. 最长递增子序列
	给定一个无序的整数数组，找到其中最长上升子序列的长度。
示例:
	输入: [10,9,2,5,3,7,101,18]
	输出: 4
	解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。*/
	//动态规划，一个相同长度的大小，用来存储前面的状态变量值。
	public static int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int maxans = 1;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxans = Math.max(maxans, dp[i]);
		}
		return maxans;
	}

	/*322. 零钱兑换
	给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
	你可以认为每种硬币的数量是无限的。
示例 1：
	输入：coins = [1, 2, 5], amount = 11
	输出：3
	解释：11 = 5 + 5 + 1
	示例 2：
	输入：coins = [2], amount = 3
	输出：-1
	示例 3：
	输入：coins = [1], amount = 0
	输出：0
	示例 4：
	输入：coins = [1], amount = 1
	输出：1
	示例 5：
	输入：coins = [1], amount = 2
	输出：2*/
	//会超时
	private Integer res=Integer.MAX_VALUE;
	public int coinChange(int[] coins, int amount) {
		if(coins==null||coins.length==0){
			return -1;
		}
		findWays(coins, amount, 0);
		return res==Integer.MAX_VALUE?-1:res;

	}
	public void findWays(int[] coins,int amount,int count){
		if(amount<0){
			return;
		}
		if(amount==0){
			res=Math.min(res,count);
		}
		for(int i=0;i<coins.length;i++){
			findWays(coins, amount-coins[i], count+1);
		}
	}

	/*242. 有效的字母异位词
	给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
	示例 1:
	输入: s = "anagram", t = "nagaram"
	输出: true
	示例 2:

	输入: s = "rat", t = "car"
	输出: false*/
	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length()){
			return false;
		}
		int[] table=new int[26];
		for(int i=0;i<s.length();i++){
			table[s.charAt(i)-'a']++;
		}
		for(int j=0;j<t.length();j++){
			table[t.charAt(j)-'a']--;
			if(table[t.charAt(j)-'a']<0){
				return false;
			}
		}
		return true;

	}

	/*剑指 Offer 13. 机器人的运动范围
	地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
	也不能进入行坐标和列坐标的数位之和大于k的格子。
	例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
	示例 1：
	输入：m = 2, n = 3, k = 1
	输出：3
	示例 2：
	输入：m = 3, n = 1, k = 0
	输出：1*/
	//广度优先遍历
	public int movingCount(int m, int n, int k) {
		boolean[][] visited = new boolean[m][n];
		int res = 0;
		Queue<int[]> queue= new LinkedList<int[]>();
		queue.add(new int[] { 0, 0, 0, 0 });
		while(!queue.isEmpty()) {
			int[] x = queue.poll();
			int i = x[0], j = x[1], si = x[2], sj = x[3];
			if(i >= m || j >= n || si + sj>k || visited[i][j]) {
				continue;
			}
			visited[i][j] = true;
			res ++;
			//向下走
			queue.add(new int[] { i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj });
			//向右走
			queue.add(new int[] { i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8 });
		}
		return res;
	}

	/*155. 最小栈
	设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

	push(x) —— 将元素 x 推入栈中。
	pop() —— 删除栈顶的元素。
	top() —— 获取栈顶元素。
	getMin() —— 检索栈中的最小元素。
*/
	private Stack<Integer> stack1=new Stack<>();
	private Stack<Integer> stack2=new Stack<>();
	public void push(int x) {
		stack1.push(x);
		if(stack2.isEmpty()||stack2.peek()>=x){
			stack2.push(x);
		}
	}

	public void pop() {
		if(stack1.pop().equals(stack2.peek())){
			stack2.pop();
		}
	}

	public int top() {
		return stack1.peek();
	}

	public int getMin() {
		return stack2.peek();

	}

	/*面试题 01.01. 判定字符是否唯一
	实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
	示例 1：
	输入: s = "leetcode"
	输出: false
	示例 2：

	输入: s = "abc"
	输出: true*/
	public boolean isUnique(String astr) {
		for(int i=0;i<astr.length();i++){
			if(i!=astr.lastIndexOf(astr.charAt(i))){
				return false;
			}
		}
		return true;
	}

	/*112. 路径总和
	给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
	说明: 叶子节点是指没有子节点的节点。
	示例:
	给定如下二叉树，以及目标和 sum = 22，

			5
			/ \
			4   8
			/   / \
			11  13  4
			/  \      \
			7    2      1
	返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。*/
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		int val = root.val;
		if (root.left == null && root.right == null && val == sum) {
			return true;
		}
		return hasPathSum(root.left, sum - val) || hasPathSum(root.right, sum - val);
	}

	/*63. 不同路径 II
	一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
	机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
	现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？*/

	//重新定义一个新的数组，这样初始值都为0，不容易混乱
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0) {
			return 0;
		}

		// 定义 dp 数组并初始化第 1 行和第 1 列。
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
			dp[i][0] = 1;
		}
		for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
			dp[0][j] = 1;
		}

		// 根据状态转移方程 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 进行递推。
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}

   /*409. 最长回文串
	给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
	在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
	注意:
	假设字符串的长度不会超过 1010。
	示例 1:
	输入:
			"abccccdd"
	输出:
			7
	解释:
	我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。*/
   public int longestPalindrome(String s) {
	   if (s.length() == 0) {
		   return 0;
	   }
	   // 用于存放字符
	   HashSet<Character> hashset = new HashSet<Character>();
	   int count = 0;
	   for (int i = 0; i < s.length(); i++) {
		   if (!hashset.contains(s.charAt(i))) {// 如果hashset没有该字符就保存进去
			   hashset.add(s.charAt(i));
		   } else {
		   	// 如果有,就让count++（说明找到了一个成对的字符），然后把该字符移除
			   hashset.remove(s.charAt(i));
			   count++;
		   }
	   }
	   return hashset.isEmpty() ? count * 2 : count * 2 + 1;
   }

   /*199. 二叉树的右视图
	给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
	示例:
	输入: [1,2,3,null,5,null,4]
	输出: [1, 3, 4]
	解释:

			1            <---
			/   \
			2     3         <---
			\     \
			5     4       <---*/
   public List<Integer> rightSideView(TreeNode root) {
	   List<Integer> result = new ArrayList<>();
	   if (root == null) {
		   return result;
	   }
	   Queue<TreeNode> queue = new LinkedList<>();
	   queue.add(root);
	   while (!queue.isEmpty()) {
		   int size = queue.size();
		   for (int i = 0; i < size; i++) {
			   TreeNode treeNode = queue.poll();
			   if (i == 0) {
				   result.add(treeNode.val);
			   }

			   if (treeNode.right != null) {
				   queue.add(treeNode.right);
			   }
			   if (treeNode.left != null) {
				   queue.add(treeNode.left);
			   }
		   }

	   }
	   return result;
   }

   /*41. 缺失的第一个正数
	给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
示例 1:
	输入: [1,2,0]
	输出: 3
	示例 2:
	输入: [3,4,-1,1]
	输出: 2
	示例 3:
	输入: [7,8,9,11,12]
	输出: 1*/
	//思路比较复杂
   public int firstMissingPositive(int[] nums) {
	   int n = nums.length;
	   for (int i = 0; i < n; ++i) {
		   if (nums[i] <= 0) {
			   nums[i] = n + 1;
		   }
	   }
	   for (int i = 0; i < n; ++i) {
		   int num = Math.abs(nums[i]);
		   if (num <= n) {
			   nums[num - 1] = -Math.abs(nums[num - 1]);
		   }
	   }
	   for (int i = 0; i < n; ++i) {
		   if (nums[i] > 0) {
			   return i + 1;
		   }
	   }
	   return n + 1;
   }

   /*160. 相交链表
	编写一个程序，找到两个单链表相交的起始节点。*/
   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	   if (headA == null || headB == null) {
		   return null;
	   }
	   ListNode pA = headA, pB = headB;
	   while (pA != pB) {
		   pA = pA == null ? headB : pA.next;
		   pB = pB == null ? headA : pB.next;
	   }
	   return pA;
   }

	/*剑指 Offer 58 - II. 左旋转字符串
	字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
	比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
示例 1：
	输入: s = "abcdefg", k = 2
	输出: "cdefgab"
	示例 2：
	输入: s = "lrloseumgh", k = 6
	输出: "umghlrlose"*/
	public String reverseLeftWords(String s, int n) {
		StringBuilder res = new StringBuilder();
		for(int i = n; i < s.length(); i++)
			res.append(s.charAt(i));
		for(int i = 0; i < n; i++)
			res.append(s.charAt(i));
		return res.toString();
	}

	/*142. 环形链表 II
	给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
	为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
	注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。*/
	public ListNode detectCycle(ListNode head) {
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

	/*48. 旋转图像
	给定一个 n × n 的二维矩阵表示一个图像。
	将图像顺时针旋转 90 度。
	说明：
	你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
	示例 1:
	给定 matrix =
[
		[1,2,3],
		[4,5,6],
		[7,8,9]
		],

	原地旋转输入矩阵，使其变为:
			[
			[7,4,1],
			[8,5,2],
			[9,6,3]
			]*/
	public void rotate(int[][] matrix) {
		int n = matrix.length;

		// transpose matrix
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				int tmp = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = tmp;
			}
		}
		// reverse each row
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = tmp;
			}
		}
	}

	/*61. 旋转链表
	给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
	示例 1:
	输入: 1->2->3->4->5->NULL, k = 2
	输出: 4->5->1->2->3->NULL
	解释:
	向右旋转 1 步: 5->1->2->3->4->NULL
	向右旋转 2 步: 4->5->1->2->3->NULL
	示例 2:
	输入: 0->1->2->NULL, k = 4
	输出: 2->0->1->NULL
	解释:
	向右旋转 1 步: 2->0->1->NULL
	向右旋转 2 步: 1->2->0->NULL
	向右旋转 3 步: 0->1->2->NULL
	向右旋转 4 步: 2->0->1->NULL*/
	public ListNode rotateRight(ListNode head, int k) {
		// base cases
		if (head == null || head.next == null) {
			return head;
		}

		// close the linked list into the ring
		ListNode old_tail = head;
		int n;
		for (n = 1; old_tail.next != null; n++) {
			old_tail = old_tail.next;
		}

		old_tail.next = head;
		// find new tail : (n - k % n - 1)th node
		// and new head : (n - k % n)th node
		ListNode new_tail = head;
		for (int i = 1; i < n - k % n; i++) {
			new_tail = new_tail.next;
		}

		ListNode new_head = new_tail.next;
		// break the ring
		new_tail.next = null;
		return new_head;
	}
	/*83. 删除排序链表中的重复元素
	给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
	示例 1:
	输入: 1->1->2
	输出: 1->2
	示例 2:
	输入: 1->1->2->3->3
	输出: 1->2->3*/
	public ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return head;
	}

	//两数相除
	/*给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
	返回被除数dividend除以除数divisor得到的商。
	整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
	示例1:
	输入: dividend = 10, divisor = 3
	输出: 3
	解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
	示例2:
	输入: dividend = 7, divisor = -3
	输出: -2
	解释: 7/-3 = truncate(-2.33333..) = -2
	*/



}


