package com.example.demo4.TIJIE;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description: 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * @Author: wangwei
 * @Date: 2020/11/22 下午10:17
 */
public class IsValid6 {
	public boolean isValid(String s) {
		int length=s.length();
		if(length%2==1){
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
}
