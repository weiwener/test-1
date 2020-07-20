package com.example.demo4;

/**
 * @Description: 常量
 * @Author: wangwei
 * @Date: 2019/12/18 下午9:02
 */
public class TestD {

	public static void main(String[] args) {
		Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

		System.out.println(f1 == f2);
		System.out.println(f3 == f4);
		System.out.println(f3.equals(f4));
		String s1 = new StringBuilder("go")
				.append("od").toString();
		System.out.println(s1.intern() == s1);
		String s2 = new StringBuilder("ja")
				.append("va").toString();
		System.out.println(s2.intern() == s2);
		test2();
	}

	public static void test1(){
		String str1 = "abcd";

		String str2 = "abcd";

		String str3 = new String("abcd");

		String str4 = new String("abcd");

		System.out.println(str1==str2);
		System.out.println(str2==str3);
		System.out.println(str2==str3.intern());
		System.out.println(str3==str4);
	}

	public static void test2(){
		String str1 = "str";
		String str2 = "ing";

		String str3 = "str" + "ing";//常量池中的对象
		String str4 = str1 + str2; //在堆上创建的新的对象
		String str5 = "string";//常量池中的对象
		System.out.println(str3 == str4);
		System.out.println(str3 == str5);
		System.out.println(str4 == str5);
	}

	public static void test3(){
		String s1 = new String("abc");// 堆内存的地址值
		String s2 = "abc";
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
	}
}
