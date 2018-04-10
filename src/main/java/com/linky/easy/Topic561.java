package com.linky.easy;

import java.util.Arrays;

/**
 * Array Partition I
 * https://leetcode.com/problems/array-partition-i/description/
 */
public class Topic561 {

    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {


    }
}
