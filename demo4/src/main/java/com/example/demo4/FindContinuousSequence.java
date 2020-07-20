package com.example.demo4;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: wangwei
 * @Date: 2020/6/20 下午11:02
 */
public class FindContinuousSequence {
	public static void main(String[] args) {
		//findContinuousSequence(9);
		int a=6;
		System.out.println(a);
		a=copy(a);
		System.out.println(a);
	}

	public static int[][] findContinuousSequence(int target) {
		List<int[]> res = new ArrayList<>();
		//左边界
		int i=1;
		//右边界
		int j=1;
		int sum=0;
		while(i<=target/2){
			if(sum<target){
				sum+=j;
				j++;
			}else if(sum==target){
				int arr[]=new int[j-i];
				for(int m=0;m<j-i;m++){
					arr[m]=i+m;
				}
				res.add(arr);
				sum-=i;
				i++;
				j++;
			}else if(sum>target){
				sum-=i;
				i++;
			}
		}
		return res.toArray(new int[res.size()][]);
	}

	private static int copy(int a){
		a=5;
		System.out.println(a);
		return a;
	}

}
