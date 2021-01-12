package com.example.demo4.Strings;

import java.util.HashMap;
import java.util.Map;

/** 中等
 * @Description: 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * @Author: wangwei
 * @Date: 2020/11/22 下午12:33
 */
public class LengthOfLongestSubstring {
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
}
