package com.example.demo4.TIJIE;

/**
 * @Description:
 * @Author: wangwei
 * @Date: 2020/11/22 下午10:21
 */
public class Solution {
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

/*	14. 最长公共前缀
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

	通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

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
	给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
	不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
	元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
示例 1:

	给定 nums = [3,2,2,3], val = 3,

	函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

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
				nums[i] = nums[j];
				i++;
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
		/*for(int i=0;i<nums.length;i++){
			if(target==nums[i]){
				return i;
			}
			if(target<nums[i]){
				return i;
			}
		}
		return nums.length;*/
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
			int currLen = 0, pL = 0;
			while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
				++pn;
				++pL;
				++currLen;
			}
			if (currLen == L) {
				return pn - L;
			}
			pn = pn - currLen + 1;
		}
		return -1;
	}

	/*11. 盛最多水的容器
	给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
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
}
