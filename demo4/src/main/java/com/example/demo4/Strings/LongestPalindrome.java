package com.example.demo4.Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Description: 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * @Author: wangwei
 * @Date: 2020/10/26 下午3:11
 */
public class LongestPalindrome {
	public static int longestPalindrome(String s) {
/*		int result=0;
		Map<Character,Integer> map=new HashMap<>();
		for(int i=0;i<s.length();i++){
			if(map.get(s.charAt(i))!=null){
				map.put(s.charAt(i),map.get(s.charAt(i))+1);
			}else {
				map.put(s.charAt(i),1);
			}
		}
		boolean flag=false;
		for(Character key:map.keySet()){
			if(map.get(key)%2==0){
				result+=map.get(key);
			}else{
				flag=true;
				result=result+map.get(key)-1;
			}
		}
		if(flag){
			result++;
		}
		return result;*/

		if (s.length() == 0) {
			return 0;
		}
		// 用于存放字符
		HashSet<Character> hashset = new HashSet<Character>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (!hashset.contains(s.charAt(i))) {// 如果hashset没有该字符就保存进去
				hashset.add(s.charAt(i));
			} else {// 如果有,就让count++（说明找到了一个成对的字符），然后把该字符移除
				hashset.remove(s.charAt(i));
				count++;
			}
		}
		return hashset.isEmpty() ? count * 2 : count * 2 + 1;
	}

	public static void main(String[] args) {
		String s="abccccdd";
		int a=longestPalindrome(s);
	}
}
