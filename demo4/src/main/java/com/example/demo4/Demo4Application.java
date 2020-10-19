package com.example.demo4;

import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Mac;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@SpringBootApplication
public class Demo4Application {

//	public static void main(String[] args) {
//		SpringApplication.run(Demo4Application.class, args);
//	}
	public static void main(String[] args) {
//		int[] arr={3,2,4};
//		int target=6;
//
//		int val = 4;
//		String s=countAndSay(4);
		//test2();

		String s1 = "Programming";
		String s2 = new String("Programming");
		String s3 = "Program";
		String s4 = "ming";
		String s5 = "Program" + "ming";
		String s6 = s3 + s4;
		System.out.println(s1 == s2);
		System.out.println(s1 == s5);
		System.out.println(s1 == s6);
		System.out.println(s1 == s6.intern());
		System.out.println(s2 == s2.intern());


	}

	@RequestMapping
	public String hello() {
		return "hello spring boot!";
	}

	/**
	 * 1.两数之和
	 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
	 *
	 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
	 *
	 *  
	 *
	 * 示例:
	 *
	 * 给定 nums = [2, 7, 11, 15], target = 9
	 *
	 * 因为 nums[0] + nums[1] = 2 + 7 = 9
	 * 所以返回 [0, 1]
	 *
	 *
	 * @param nums,target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		int[] result=new int[2];
		int length=nums.length;

		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<length;i++){
			int dif=target-nums[i];
			if(map.get(dif)==null){
				map.put(dif,i);
			}else if(map.get(dif)!=i){
				map.put(dif,i);
			}

		}

		for(int i=0;i<length;i++){
			if(map.get(nums[i])!=null&&map.get(nums[i])!=i){
				int j=map.get(nums[i]);
				if(i<j){
					result[0]=i;
					result[1]=j;
				}else {
					result[0]=j;
					result[1]=i;
				}
				break;

			}
		}
		return result;
	}

	/**
	 * 整数反转
	 *
	 * @param x
	 * @return
	 */
	public static int reverse(int x){
		String a=String.valueOf(x);

		String b=new StringBuffer(a).reverse().toString();
//		int y=;
		return 0;
	}

	public static double twoDelete(String a,String b){
		double x=Double.parseDouble(a);
		double y=Double.parseDouble(b);
		double z=x-y;
		BigDecimal bd1 = new BigDecimal(Double.toString(x));
		BigDecimal bd2 = new BigDecimal(Double.toString(y));
		double m= bd1.subtract(bd2).doubleValue();

		return m;
	}

	public static long tets1(String a,String b){
		long day=0;
		try{
			SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
			Date date1= df.parse(a);
			Date date2=df.parse(b);
			day=(date1.getTime()-date2.getTime())/(60*1000);
		}catch (Exception e){

		}
		return day;
	}

	public static int tets2(long a){
		double a1= Math.ceil(a/45*10);
		int a2= (int)Math.ceil(a/45*10);
		double a3=Math.ceil(a*10.0/45.0);
		double a5=Math.ceil(111.111);
		int a4=(int)a3;

		double m1=112.34;
		double m2=112.89;
		int m3=112;
		boolean flag1=m1>m3;
		boolean flag2=m2>m3;
		return a4;
	}


	//13. 罗马数字转整数
	public static int romanToInt(String s) {
		Map<Character,Integer> map=new HashMap<>(7);
		map.put('I',1);
		map.put('V',5);
		map.put('X',10);
		map.put('L',50);
		map.put('C',100);
		map.put('D',500);
		map.put('M',1000);

		Map<String,Integer> map1=new HashMap<>(6);
		map1.put("IV",4);
		map1.put("IX",9);
		map1.put("XL",40);
		map1.put("XC",90);
		map1.put("CD",400);
		map1.put("CM",900);

		int total=0;
		int flag=0;
		if(s.length()>1){
			for (int i=0;i<s.length()-1;i++){
				char left=s.charAt(i);
				int leftValue=map.get(left);
				String str=s.substring(i,i+2);
				if(map1.containsKey(str)){
					total+=map1.get(str);
					i++;
					flag=i;
				}else {
					total+=leftValue;
				}
			}
			if(flag!=s.length()-1){
				total+=map.get(s.charAt(s.length()-1));
			}
		}else {
			total=map.get(s.charAt(0));
		}

		return total;
	}

	//27. 移除元素
	public static int removeElement(int[] nums, int val) {

////		int size=0;
//		int length=nums.length;
////		for(int i=0;i<length;i++){
////			if(val==nums[i]){
////				size++;
////			}
////		}
////		int result=length-size;
//		int flag=0;
//		if(length>1){
//			for(int i=0,j=length-1;i<j;){
//				if(nums[i]!=val&&nums[j]==val){
//					i++;
//					j--;
//				}else if(nums[i]==val&&nums[j]!=val){
//					nums[i]=nums[j];
//					nums[j]=val;
//					i++;
//					j--;
//				}else if(nums[i]==val&&nums[j]==val&&i!=j){
//					j--;
//				}else if(nums[i]==val&&nums[j]==val&&i==j){
//					flag=i-1;
//				}else if(nums[i]!=val&&nums[j]!=val&&i!=j){
//					i++;
//				}else if(nums[i]!=val&&nums[j]!=val&&i==j){
//					flag=i;
//					break;
//				}
//				flag=i;
//			}
//		}else if(length==1){
//			if(nums[0]==val){
//				return 0;
//			}else {
//				return 1;
//			}
//		}else {
//			return 0;
//		}

		if (nums == null || nums.length == 0) {
			return 0;
		}
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[j] = nums[i];
				j++;
			}
		}
		return j;
	}

	//38. 报数
	public static String countAndSay(int n) {
		String a="";

		String[] strings=new String[30];
		strings[0]="1";

		for(int i=0;i<=n;i++){
			String str=strings[i];
			LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();
			for(int j=0;j<str.length();j++){
				int count=0;
				if(map.get(str.charAt(j))!=null){
					int countHave=map.get(str.charAt(j));
					map.put(str.charAt(j),++countHave);
				}else {
					map.put(str.charAt(j),1);
				}
			}
			StringBuffer stringBuffer=new StringBuffer();
			for (Map.Entry<Character, Integer> entry : map.entrySet()) {
				System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
				stringBuffer.append(entry.getValue().toString());
				stringBuffer.append(entry.getKey());
			}
			strings[i+1]=stringBuffer.toString();

		}
		return strings[n];
	}


	public static void test(){
		String str1 = "abcd";

		String str2 = "abcd";

		String str3 = new String("abcd");

		String str4 = new String("abcd");

		System.out.println(str1==str2);
		System.out.println(str2==str3);
		System.out.println(str2==str3.intern());
		System.out.println(str3==str4);
	}

	public static void test1(){
		String str1 = "str";
		String str2 = "ing";

		String str3 = "str" + "ing";//常量池中的对象
		String str4 = str1 + str2; //在堆上创建的新的对象
		String str5 = "string";//常量池中的对象
		System.out.println(str3 == str4);
		System.out.println(str3 == str5);
		System.out.println(str4 == str5);
	}

	public static void test2(){
		String s1 = new String("abc");// 堆内存的地址值
		String s2 = "abc";
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
	}

}
