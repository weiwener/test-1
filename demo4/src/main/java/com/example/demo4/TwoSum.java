package com.example.demo4;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 两数之和
 * @Author: wangwei
 * @Date: 2020/10/16 下午3:28
 */
public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i]) != null) {
				return new int[]{map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return new int[]{0};
	}
}
