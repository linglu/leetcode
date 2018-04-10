package com.linky.easy;

import com.linky.stdlib.StdOut;

/**
 * Reverse Words in a String III
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 */
public class Topic557 {

    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");

        for (String str : ss) {
            sb.append(reverseString(str)).append(" ");
        }

        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    private String reverseString(String s) {

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
        StdOut.println(new Topic557().reverseWords(args[0]));
    }
}
