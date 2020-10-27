package com.example.demo4;

import java.util.Objects;

/**
 * @Description: 验证是否回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * @Author: wangwei
 * @Date: 2020/10/26 下午3:44
 */
public class IsPalindrome {
	public static boolean isPalindrome(String s) {
		/*if(s==null||s.length()==0){
			return true;
		}
		int right=s.length()-1;
		int left=0;
		while(left<right){
			if((s.charAt(left)+"").equalsIgnoreCase(s.charAt(right)+"")){
				left++;
				right--;
			}else{
				if(!Character.isDigit(s.charAt(left))&&!Character.isLetter(s.charAt(left))){
					left++;
					continue;
				}
				if(!Character.isDigit(s.charAt(right))&&!Character.isLetter(s.charAt(right))){
					right--;
					continue;
				}
				break;
			}
		}
		if(left-right==1||right==left){
			return true;
		}
		return false;*/
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

	public static void main(String[] args) {
		String s="race a car";
		boolean a=isPalindrome(s);
	}
}
