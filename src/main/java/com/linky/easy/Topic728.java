package com.linky.easy;

import com.linky.stdlib.StdOut;

import java.util.ArrayList;
import java.util.List;

/**
 * Self Dividing Numbers
 * https://leetcode.com/problems/self-dividing-numbers/description/
 */
public class Topic728 {

    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> result = new ArrayList<>();
        for (int number = left; number <= right; number++) {

            int base = 1;
            boolean isDivided = true;

            // 商不为 0 时
            while (number / base != 0) {

                int digit = number / base % 10;
                if (digit == 0 || number % digit != 0) {
                    isDivided = false;
                    break;
                }

                base *= 10;
            }

            if (isDivided) {
                result.add(number);
            }

        }

        return result;
    }

    public static void main(String[] args) {

        int left = Integer.parseInt(args[0]);
        int right = Integer.parseInt(args[1]);
        List<Integer> li = new Topic728().selfDividingNumbers(left, right);

        for (Integer aLi : li) {
            StdOut.print(aLi + " ");
        }
    }
}
