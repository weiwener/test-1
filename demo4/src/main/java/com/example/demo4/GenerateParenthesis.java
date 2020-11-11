/*
package com.example.demo4;

import java.util.ArrayList;
import java.util.List;

*/
/** 中等
 * @Description: 括号生成
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * @Author: wangwei
 * @Date: 2020/11/10 下午6:14
 *//*

public class GenerateParenthesis {
	public static List<String> generateParenthesis(int n) {
		return null;
	}

	public static void main(String[] args) {

	}


//	首先，面向小白：什么是动态规划？在此题中，动态规划的思想类似于数学归纳法，当知道所有 i<n 的情况时，我们可以通过某种算法算出 i=n 的情况。
//	本题最核心的思想是，考虑 i=n 时相比 n-1 组括号增加的那一组括号的位置。
//
//	思路：
//	当我们清楚所有 i<n 时括号的可能生成排列后，对与 i=n 的情况，我们考虑整个括号排列中最左边的括号。
//	它一定是一个左括号，那么它可以和它对应的右括号组成一组完整的括号 "( )"，我们认为这一组是相比 n-1 增加进来的括号。
//
//	那么，剩下 n-1 组括号有可能在哪呢？
//
//			【这里是重点，请着重理解】
//
//	剩下的括号要么在这一组新增的括号内部，要么在这一组新增括号的外部（右侧）。
//
//	既然知道了 i<n 的情况，那我们就可以对所有情况进行遍历：
//
//			"(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】
//
//	其中 p + q = n-1，且 p q 均为非负整数。
//
//	事实上，当上述 p 从 0 取到 n-1，q 从 n-1 取到 0 后，所有情况就遍历完了。
//
//	注：上述遍历是没有重复情况出现的，即当 (p1,q1)≠(p2,q2) 时，按上述方式取的括号组合一定不同。


//	方法一：暴力法
//			思路
//
//	我们可以生成所有 2^{2n}2
//			2n
//	个 '(' 和 ')' 字符构成的序列，然后我们检查每一个是否有效即可。
//
//	算法
//
//	为了生成所有序列，我们可以使用递归。长度为 n 的序列就是在长度为 n-1 的序列前加一个 '(' 或 ')'。
//
//	为了检查序列是否有效，我们遍历这个序列，并使用一个变量 balance 表示左括号的数量减去右括号的数量。如果在遍历过程中 balance 的值小于零，或者结束时 balance 的值不为零，那么该序列就是无效的，否则它是有效的。
//
//	JavaPython3C++

	class Solution {
		public List<String> generateParenthesis(int n) {
			List<String> combinations = new ArrayList<String>();
			generateAll(new char[2 * n], 0, combinations);
			return combinations;
		}

		public void generateAll(char[] current, int pos, List<String> result) {
			if (pos == current.length) {
				if (valid(current)) {
					result.add(new String(current));
				}
			} else {
				current[pos] = '(';
				generateAll(current, pos + 1, result);
				current[pos] = ')';
				generateAll(current, pos + 1, result);
			}
		}

		public boolean valid(char[] current) {
			int balance = 0;
			for (char c: current) {
				if (c == '(') {
					++balance;
				} else {
					--balance;
				}
				if (balance < 0) {
					return false;
				}
			}
			return balance == 0;
		}
	}
//	复杂度分析
//
//	时间复杂度：O(2^{2n}n)O(2
//							  2n
//							  n)，对于 2^{2n}2
//			2n
//	个序列中的每一个，我们用于建立和验证该序列的复杂度为 O(n)O(n)。
//
//	空间复杂度：O(n)O(n)，除了答案数组之外，我们所需要的空间取决于递归栈的深度，每一层递归函数需要 O(1)O(1) 的空间，最多递归 2n2n 层，因此空间复杂度为 O(n)O(n)。
//
//	方法二：回溯法
//			思路和算法
//
//	方法一还有改进的余地：我们可以只在序列仍然保持有效时才添加 '(' or ')'，而不是像 方法一 那样每次添加。我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
//
//	如果左括号数量不大于 nn，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号。
//
//	JavaPython3C++

	class Solution {
		public List<String> generateParenthesis(int n) {
			List<String> ans = new ArrayList<String>();
			backtrack(ans, new StringBuilder(), 0, 0, n);
			return ans;
		}

		public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
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
	}
//	复杂度分析
//
//	我们的复杂度分析依赖于理解 generateParenthesis(n) 中有多少个元素。这个分析超出了本文的范畴，但事实证明这是第 nn 个卡特兰数 \dfrac{1}{n+1}\dbinom{2n}{n}
//	n+1
//			1
//			​
//			(
//	n
//2n
//​
//		)，这是由 \dfrac{4^n}{n\sqrt{n}}
//	n
//			n
//​
//
//		4
//	n
//
//​
//	渐近界定的。
//
//	时间复杂度：O(\dfrac{4^n}{\sqrt{n}})O(
//			n
//​
//
//		4
//		n
//
//		​
//	)，在回溯过程中，每个答案需要 O(n)O(n) 的时间复制到答案数组中。
//
//	空间复杂度：O(n)O(n)，除了答案数组之外，我们所需要的空间取决于递归栈的深度，每一层递归函数需要 O(1)O(1) 的空间，最多递归 2n2n 层，因此空间复杂度为 O(n)O(n)。
//
//	方法三：按括号序列的长度递归
//			思路与算法
//
//	任何一个括号序列都一定是由 ( 开头，并且第一个 ( 一定有一个唯一与之对应的 )。这样一来，每一个括号序列可以用 (a)b 来表示，其中 a 与 b 分别是一个合法的括号序列（可以为空）。
//
//	那么，要生成所有长度为 2 * n 的括号序列，我们定义一个函数 generate(n) 来返回所有可能的括号序列。那么在函数 generate(n) 的过程中：
//
//	我们需要枚举与第一个 ( 对应的 ) 的位置 2 * i + 1；
//	递归调用 generate(i) 即可计算 a 的所有可能性；
//	递归调用 generate(n - i - 1) 即可计算 b 的所有可能性；
//	遍历 a 与 b 的所有可能性并拼接，即可得到所有长度为 2 * n 的括号序列。
//	为了节省计算时间，我们在每次 generate(i) 函数返回之前，把返回值存储起来，下次再调用 generate(i) 时可以直接返回，不需要再递归计算。
//
//	JavaPython3C++

	class Solution {
		ArrayList[] cache = new ArrayList[100];

		public List<String> generate(int n) {
			if (cache[n] != null) {
				return cache[n];
			}
			ArrayList<String> ans = new ArrayList<String>();
			if (n == 0) {
				ans.add("");
			} else {
				for (int c = 0; c < n; ++c) {
					for (String left: generate(c)) {
						for (String right: generate(n - 1 - c)) {
							ans.add("(" + left + ")" + right);
						}
					}
				}
			}
			cache[n] = ans;
			return ans;
		}

		public List<String> generateParenthesis(int n) {
			return generate(n);
		}
	}


}
*/
