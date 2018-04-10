package com.linky.easy;

import com.linky.stdlib.StdOut;

/**
 * Reverse String
 * https://leetcode.com/problems/reverse-string/description/
 */
public class Topic344 {

    /**
     * 反转字符串
     */
    public String reverseString(String s) {

        char[] c = s.toCharArray();
        int hi = c.length - 1;
        int mid = (hi + 1) / 2;

        char t;
        for (int i = 0; i < mid; i++) {
            t = c[i];
            c[i] = c[hi];
            c[hi] = t;
            hi--;
        }

        return String.valueOf(c);
    }

    public static void main(String[] args) {
        StdOut.println(new Topic344().reverseString(args[0]));
    }
}
