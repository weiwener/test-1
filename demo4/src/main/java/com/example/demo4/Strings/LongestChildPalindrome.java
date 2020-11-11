package com.example.demo4.Strings;

/**
 * 四星-动态规划
 * @Description:  最长回文子串
 * @Author: wangwei
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 */
public class LongestChildPalindrome {
	//中心扩散法
	/*private int index, len;

	public String longestPalindrome(String s) {
		if (s.length() < 2)
			return s;
		for (int i = 0; i < s.length() - 1; i++) {
			palindromeHelper(s, i, i);
			palindromeHelper(s, i, i + 1);
		}
		return s.substring(index, index + len);
	}

	public void palindromeHelper(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		if (len < r - l - 1) {
			index = l + 1;
			len = r - l - 1;
		}
	}*/

	//动态规划法
	public static String longestPalindrome(String s) {
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

	public static void main(String[] args) {
		String s="babad";
		longestPalindrome(s);
	}

}
