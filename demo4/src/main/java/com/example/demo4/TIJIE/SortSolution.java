package com.example.demo4.TIJIE;

/**
 * @Description: 排序
 * @Author: wangwei
 * @Date: 2020/11/25 下午6:08
 */
public class SortSolution {

	//快速排序::时间复杂度：平均O(nlogn),不稳定
	public void QuickSort(int[] num, int left, int right) {
		//如果left等于right，即数组只有一个元素，直接返回
		if (left >= right) {
			return;
		}
		//设置最左边的元素为基准值
		int key = num[left];
		//数组中比key小的放在左边，比key大的放在右边，key值下标为i
		int i = left;
		int j = right;
		while (i < j) {
			//j向左移，直到遇到比key小的值
			while (num[j] >= key && i < j) {
				j--;
			}
			//i向右移，直到遇到比key大的值
			while (num[i] <= key && i < j) {
				i++;
			}
			//i和j指向的元素交换
			if (i < j) {
				int temp = num[i];
				num[i] = num[j];
				num[j] = temp;
			}
		}
		num[left] = num[i];
		num[i] = key;
		QuickSort(num, left, i - 1);
		QuickSort(num, i + 1, right);
	}
	/*
	 * 插入排序   稳定
	 * <li>从第一个元素开始，该元素可以认为已经被排序</li>
	 * <li>取出下一个元素，在已经排序的元素序列中从后向前扫描</li>
	 * <li>如果该元素（已排序）大于新元素，将该元素移到下一位置</li>
	 * <li>重复步骤3，直到找到已排序的元素小于或者等于新元素的位置</li>
	 * <li>将新元素插入到该位置中</li>
	 * <li>重复步骤2</li>
	 *  @param  numbers
	 */
	public void insertSort(int[] numbers) {
		int size = numbers.length, temp, j;
		for (int i = 1; i < size; i++) {
			temp = numbers[i];
			for (j = i; j > 0 && temp < numbers[j - 1]; j--){
				numbers[j] = numbers[j - 1];
			}
			numbers[j] = temp;
		}
	}

	/*
	 * 归并排序  稳定
	 * <ul>
	 * <li>申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列</li>
	 * <li>设定两个指针，最初位置分别为两个已经排序序列的起始位置</li>
	 * <li>比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置</li>
	 * <li>重复步骤3直到某一指针达到序列尾</li>
	 * <li>将另一序列剩下的所有元素直接复制到合并序列尾</li>
	 *  @param  numbers
	 */
	public static void mergeSort(int[] numbers, int left, int right) {
		//  每组元素个数
		int t = 1;
		int size = right - left + 1;
		while (t < size) {
			//  本次循环每组元素个数
			int s = t;
			t = 2 * s;
			int i = left;
			while (i + (t - 1) < size) {
				merge(numbers, i, i + (s - 1), i + (t - 1));
				i += t;
			}
			if (i + (s - 1) < right)
				merge(numbers, i, i + (s - 1), right);
		}
	}
	/*
	 * 归并算法实现
	 *
	 *  @param  data
	 *  @param  p
	 *  @param  q
	 *  @param  r
	 */
	private static void merge(int[] data, int p, int q, int r) {
		int[] B = new int[data.length];
		int s = p;
		int t = q + 1;
		int k = p;
		while (s <= q && t <= r) {
			if (data[s] <= data[t]) {
				B[k] = data[s];
				s++;
			} else {
				B[k] = data[t];
				t++;
			}
			k++;
		}
		if (s == q + 1) {
			B[k++] = data[t++];
		} else {
			B[k++] = data[s++];
		}
		for (int i = p; i <= r; i++) {
			data[i] = B[i];
		}
	}

	//冒泡排序，时间复杂度：O(n*n),稳定

	//堆排序
	public class HeapSort {
		public void HeapSort(int[] a){
			//进行第一次最大堆建立过程，对所有的非叶子节点（从下到上，从右到左）进行调整，
			//具有n个节点的完全二叉树，所有的非叶子索引从0开始，到n/2-1
			for(int i = a.length/2-1; i >= 0; i--){
				adjust(a, i, a.length);
			}
			//每次建立一个最大堆后，将根节点与最大堆最末尾一个节点进行调换
			//接着去掉这个最大末尾值，剩下所有的节点继续对根节点进行最大堆调整
			for(int i = a.length-1; i > 0; i--){
				swap(a, 0, i);
				adjust(a, 0, i);
			}
		}

		//adjustIndex为每次要调整的节点对应数组的索引，len表示每次所有调整的节点总数
		public void adjust(int[] a, int adjustIndex, int len){
			//保存要调整的节点，以便后面交换
			int temp = a[adjustIndex];
			//索引从0开始，所以子节点索引是adjustIndex*2+1
			for(int i = adjustIndex*2+1; i < len; i=2*i+1){
				//比较左节点和右节点，更新最大对应i
				if(i < len-1 && a[i] < a[i+1]) i++;
				//无需调整，直接跳出循环
				if(temp >= a[i]) break;
				//更新，同时保存替换父节点的子节点索引
				a[adjustIndex] = a[i];
				adjustIndex = i;
			}
			//将父节点赋值给最后一个调换的子节点
			a[adjustIndex] = temp;
		}
		//交换
		public void swap(int[] a, int i, int j){
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}

}
