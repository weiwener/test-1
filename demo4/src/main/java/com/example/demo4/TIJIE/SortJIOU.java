package com.example.demo4.TIJIE;

/**
 * @Description:
 * @Author: wangwei
 * @Date: 2021/1/8 下午8:07
 */
public class SortJIOU {
	public void sort(int nums[]){
		if(nums==null||nums.length==0){
			return;
		}
		int length=nums.length;
		int left=0,right=length-1;
		while(left<right){
			while(left<right&&nums[left]%2==1){
				left++;
			}
			while (left<right&&nums[right]%2==0){
				right--;
			}
			if(left<right){
				swap(nums,left,right);
				left++;
				right--;
			}
		}
	}

	public void swap(int nums[],int left,int right){
		int temp=nums[left];
		nums[left]=nums[right];
		nums[right]=temp;
	}
}
